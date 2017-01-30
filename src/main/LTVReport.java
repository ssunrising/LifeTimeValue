package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class LTVReport {
	private Data myData;
	
	public LTVReport() {
		this.myData = new Data();
	}

	public Data getMyData() {
		return myData;
	}

	public void setMyData(Data myData) {
		this.myData = myData;
	}

	private int getWeekOfYear(Event e){
		String date = e.getEvent_time().split(":")[0];
		Calendar sDateCalendar = new GregorianCalendar();		
		sDateCalendar.set(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1])-1, Integer.parseInt(date.split("-")[2]));
		return sDateCalendar.get(Calendar.WEEK_OF_YEAR);		
	}
	
	/* 
	 * this getWeekOfYear function get the week number from dates:
	 * for example: "2017-06-05:12:20.06.030"  return 23  
	 * the week number for 2017 ranges from 1 to 52, so we need -1 to get the index for the zero-indexed arrays
	*/
	private int getWeekOfYear(String date){
		Calendar sDateCalendar = new GregorianCalendar();		
		sDateCalendar.set(Integer.parseInt(date.split("-")[0]), Integer.parseInt(date.split("-")[1])-1, Integer.parseInt(date.split("-")[2]));
		return sDateCalendar.get(Calendar.WEEK_OF_YEAR);		
	}
	
	public void Ingest(Event e, Data d){
		if (e == null)
			return;
		// create new customer information in database
		if (e.getType().equals("CUSTOMER") && e.getVerb().equals("NEW")){
			Customer customer = new Customer(e);
			String key = customer.getCurstomer_id();
			myData.getM_mapCustomers().put(key, customer);			
		}
		// update customer information in database
		else if (e.getType().equals("CUSTOMER") && e.getVerb().equals("UPDATE")) {
			Customer customer = new Customer(e);
			String key = customer.getCurstomer_id();
			myData.getM_mapCustomers().put(key, customer);				
		}
		
		// process site visits information in database
		else if(e.getType().equals("SITE_VISIT") && e.getVerb().equals("NEW")) {
			SiteVisit siteVisit = new SiteVisit(e);
			myData.getM_listSiteVisits().add(siteVisit);
			
			// process site visits
			try{
				String key = siteVisit.getCustomer_id();
				String date = e.getEvent_time().split(":")[0];
				int week = getWeekOfYear(date);
				myData.setBeginWeek(Math.min(week, myData.getBeginWeek()));
				myData.setEndWeek(Math.max(week, myData.getEndWeek()));
		
				if (!myData.getM_mapLTV().containsKey(key))
					myData.getM_mapLTV().put(key, new LTVData());
	
				int cntUpdate = myData.getM_mapLTV().get(key).getM_visitCountByWeek(week-1)+1;
				myData.getM_mapLTV().get(key).setM_visitCountByWeek(week-1, cntUpdate);
			}catch(Exception cause){
				throw new RuntimeException("Cannot get Customer_id", cause);
			}
		}
		// upload image to the database for each customer
		else if(e.getType().equals("IMAGE") && e.getVerb().equals("UPLOAD")) {
			Image image = new Image(e);
			String key = image.getCustomer_id();
			myData.getM_mapImages().put(key,  image);
		}
		// create a new order
		else if(e.getType().equals("ORDER") && e.getVerb().equals("NEW")) {
			Order order = new Order(e);
			String orderKey = order.getOrder_id();
			myData.getM_mapOrders().put(orderKey, order);
			
			// process new order
			String date = e.getEvent_time().split(":")[0];
			int week = getWeekOfYear(date);
			myData.setBeginWeek(Math.min(week, myData.getBeginWeek()));
			myData.setEndWeek(Math.max(week, myData.getEndWeek()));
			try{
				String customerKey = order.getCurstomer_id();
				double expense = order.getTotal_amount();
			
				if (!myData.getM_mapLTV().containsKey(customerKey))
					myData.getM_mapLTV().put(customerKey, new LTVData());
			
				double newexpense = myData.getM_mapLTV().get(customerKey).getM_expenseByWeek(week-1) + expense;
				myData.getM_mapLTV().get(customerKey).setM_expenseByWeek(week-1, newexpense);
			}catch(Exception cause){
				throw new RuntimeException("Cannot get Customer_id", cause);
			}
		}
		
		else if(e.getType().equals("ORDER") && e.getVerb().equals("UPDATE")) {			
			Order order = new Order(e);
			String orderKey = order.getOrder_id();
			
			Order oldOrder = myData.getM_mapOrders().get(orderKey);
			String oldDate = oldOrder.getEvent_time().split(":")[0];
			int oldWeek = getWeekOfYear(oldDate);
			double oldExpense = oldOrder.getTotal_amount();
			
			myData.getM_mapOrders().put(orderKey, order);
			
			// update a previous order to new amount: substract oldexpense and then add the expense
			String date = e.getEvent_time().split(":")[0];
			int week = getWeekOfYear(date);
			myData.setBeginWeek(Math.min(week, myData.getBeginWeek()));
			myData.setEndWeek(Math.max(week, myData.getEndWeek()));
			String customerKey = order.getCurstomer_id();
			double expense = order.getTotal_amount();
			
			if (!myData.getM_mapLTV().containsKey(customerKey))
				myData.getM_mapLTV().put(customerKey, new LTVData());
						
			double expenseUpdate = myData.getM_mapLTV().get(customerKey).getM_expenseByWeek(week-1) + expense;
			myData.getM_mapLTV().get(customerKey).setM_expenseByWeek(week-1, expenseUpdate);
			double oldexpenseUpdate = myData.getM_mapLTV().get(customerKey).getM_expenseByWeek(oldWeek-1) - oldExpense;
			myData.getM_mapLTV().get(customerKey).setM_expenseByWeek(oldWeek-1, oldexpenseUpdate);			
		}
	}
	
	public TreeMap<Double, String> TopXSimpleLTVCustomers(int x, Data d){
		/* create a TreeMap ltvMa, key is the LTV, and the value is customer_id; 
		since we want the topX customer expenditures, make this map in descending order */
		TreeMap<Double, String> ltvMap = new TreeMap<>(Collections.reverseOrder());
		
		/* calculate top x with highest LVT;
		   A simple LTV can be calculated using the following equation: 52(a) x t
		   a: the average customer value per week and calculated using sum / (endWeek-beginWeek+1) * numberofWeeks
		   t: the average customer lifespan 
		*/
		for (Map.Entry<String, LTVData> entry : myData.getM_mapLTV().entrySet()){
			double sum = 0.0;
			int beginWeek = myData.getBeginWeek();
			int endWeek = myData.getEndWeek();
			for (int i = beginWeek; i <= endWeek; i++){
				sum += entry.getValue().getM_expenseByWeek(i-1);
			}
			int numberofWeeks = entry.getValue().getNumofweeks();
			int averageLifespan = entry.getValue().getAveragelifespan();
			
			double ltv = sum / (endWeek-beginWeek+1) * numberofWeeks * averageLifespan;
			ltvMap.put(ltv, entry.getKey());
			// if the map size is larger than x, we pop out 
			if(ltvMap.size() > x) ltvMap.pollLastEntry();
		}
		
		// iterate this ltvMap 
		for (Map.Entry<Double, String> entry : ltvMap.entrySet()){
			double ltv = entry.getKey();
			String customerid = entry.getValue();
			String last_name = myData.getM_mapCustomers().get(customerid).getLast_name();
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			String ltvStr = decimalFormat.format(ltv);
			System.out.println(ltvStr + "  " + customerid +  "  " + last_name);
			
		}
		// return this ltvMap which contains topX customer expenditures
		return ltvMap;
	}
	
	public void ReadDataFromFile(String filename) {
		String file = "input/" + filename;
		try{
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null){
				Event e = new Event(line);
				Ingest(e, myData);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		LTVReport report = new LTVReport();
		//String filename = "SimpleTestC.txt";
		String filename = "events.txt";
		report.ReadDataFromFile(filename);
		report.TopXSimpleLTVCustomers(2, report.myData);	
	}
}
