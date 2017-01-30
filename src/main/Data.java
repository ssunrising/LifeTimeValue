package main;

import java.util.*;

public class Data {
	/* 
	 * Data class contains all the data from a input file:
	 * HashMap m_mapCustomers describes input related to Customers, key is customer_id, value is Customer Object
	 * m_listSiteVisits is a list of all site visits, behave like a no-sql database, append only
	 * HashMap m_mapImages describes input related to Images, key is customer_id, value is Image Object
	 * HashMap m_mapOrders describes input related to Orders, key is order_id, value is Order Object
	 * HashMap m_mapLTV describes input related to LTV, key is customer_id, value is LTVData Object
	 */
	private HashMap<String, Customer> m_mapCustomers;
	private List<SiteVisit> m_listSiteVisits;
	private HashMap<String, Image> m_mapImages;
	private HashMap<String, Order> m_mapOrders;
	private HashMap<String, LTVData> m_mapLTV;
	private int beginWeek;		// used to indicate the begin week of all customers of the current data
	private int endWeek;		// used to indicate the end week of all customers of the current data
	

	public Data(HashMap<String, Customer> m_mapCustomers, List<SiteVisit> m_listSiteVisits,
			HashMap<String, Image> m_mapImages, HashMap<String, Order> m_mapOrders, HashMap<String, LTVData> m_mapLTV,
			int beginWeek, int endWeek) {
		super();
		this.m_mapCustomers = m_mapCustomers;
		this.m_listSiteVisits = m_listSiteVisits;
		this.m_mapImages = m_mapImages;
		this.m_mapOrders = m_mapOrders;
		this.m_mapLTV = m_mapLTV;
		this.beginWeek = beginWeek;
		this.endWeek = endWeek;
	}

	public Data() {
		// TODO Auto-generated constructor stub
		this.m_mapCustomers = new HashMap<String, Customer>();
		this.m_listSiteVisits = new ArrayList<>();
		this.m_mapImages = new HashMap<String, Image>();
		this.m_mapOrders = new HashMap<String, Order>();
		this.m_mapLTV = new HashMap<String, LTVData>();
		this.beginWeek = 52;
		this.endWeek = 1;
	}

	
	public HashMap<String, Customer> getM_mapCustomers() {
		return m_mapCustomers;
	}

	public void setM_mapCustomers(HashMap<String, Customer> m_mapCustomers) {
		this.m_mapCustomers = m_mapCustomers;
	}

	public List<SiteVisit> getM_listSiteVisits() {
		return m_listSiteVisits;
	}

	public void setM_listSiteVisits(List<SiteVisit> m_listSiteVisits) {
		this.m_listSiteVisits = m_listSiteVisits;
	}

	public HashMap<String, Image> getM_mapImages() {
		return m_mapImages;
	}

	public void setM_mapImages(HashMap<String, Image> m_mapImages) {
		this.m_mapImages = m_mapImages;
	}

	public HashMap<String, Order> getM_mapOrders() {
		return m_mapOrders;
	}

	public void setM_mapOrders(HashMap<String, Order> m_mapOrders) {
		this.m_mapOrders = m_mapOrders;
	}

	public HashMap<String, LTVData> getM_mapLTV() {
		return m_mapLTV;
	}

	public void setM_mapLTV(HashMap<String, LTVData> m_mapLTV) {
		this.m_mapLTV = m_mapLTV;
	}

	public int getBeginWeek() {
		return beginWeek;
	}

	public void setBeginWeek(int beginWeek) {
		this.beginWeek = beginWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_listSiteVisits == null) ? 0 : m_listSiteVisits.hashCode());
		result = prime * result + ((m_mapCustomers == null) ? 0 : m_mapCustomers.hashCode());
		result = prime * result + ((m_mapImages == null) ? 0 : m_mapImages.hashCode());
		result = prime * result + ((m_mapLTV == null) ? 0 : m_mapLTV.hashCode());
		result = prime * result + ((m_mapOrders == null) ? 0 : m_mapOrders.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (m_listSiteVisits == null) {
			if (other.m_listSiteVisits != null)
				return false;
		} else if (!m_listSiteVisits.equals(other.m_listSiteVisits))
			return false;
		if (m_mapCustomers == null) {
			if (other.m_mapCustomers != null)
				return false;
		} else if (!m_mapCustomers.equals(other.m_mapCustomers))
			return false;
		if (m_mapImages == null) {
			if (other.m_mapImages != null)
				return false;
		} else if (!m_mapImages.equals(other.m_mapImages))
			return false;
		if (m_mapLTV == null) {
			if (other.m_mapLTV != null)
				return false;
		} else if (!m_mapLTV.equals(other.m_mapLTV))
			return false;
		if (m_mapOrders == null) {
			if (other.m_mapOrders != null)
				return false;
		} else if (!m_mapOrders.equals(other.m_mapOrders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [m_mapCustomers=" + m_mapCustomers + ", m_listSiteVisits=" + m_listSiteVisits + ", m_mapImages="
				+ m_mapImages + ", m_mapOrders=" + m_mapOrders + ", m_mapLTV=" + m_mapLTV + "]";
	}

	
	
}
