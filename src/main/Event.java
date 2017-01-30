package main;

import java.util.HashMap;
import java.util.List;

public class Event {
	// shared
	private String type;
	private String verb;
	private String key;
	private String event_time;

	private String customer_id;
	
	// for Customer class
	private String last_name;
	private String adr_city;
	private String adr_state;
	
	// for SiteVisit class
	private HashMap<String, String> tags;
	
	// for Image class
	private String image_id;
	private String camera_make;
	private String camera_model;
    
	// for Order class
	private String order_id;
	private double total_amount;
	
	public Event(String type, String verb, String key, String event_time, String customer_id, String last_name,
			String adr_city, String adr_state, HashMap<String, String> tags, String image_id, String camera_make,
			String camera_model, String order_id, double total_amount) {
		super();
		this.type = type;
		this.verb = verb;
		this.key = key;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.last_name = last_name;
		this.adr_city = adr_city;
		this.adr_state = adr_state;
		this.tags = tags;
		this.image_id = image_id;
		this.camera_make = camera_make;
		this.camera_model = camera_model;
		this.order_id = order_id;
		this.total_amount = total_amount;
	}

	public Event(String str){
		String[] entries = str.split(",");
		for (int i = 0; i < entries.length; i++){
			String info = entries[i];
			if (info == null || info.length() == 0) continue;
			
			int j = 0, n = info.length();
			StringBuilder A = new StringBuilder();
			StringBuilder B = new StringBuilder();
			while(j < n && info.charAt(j) != '\"') ++j;
			++j;
			while(j < n && info.charAt(j) != '\"') A.append(info.charAt(j++));
			++j;
			if(!A.toString().equals("tags")) {
				while(j < n && info.charAt(j) != '\"') ++j;
				++j;
				while(j < n && info.charAt(j) != '\"') B.append(info.charAt(j++));
				++j;
			}
			else {
				// deal with tag information
			}
			
			if(A.toString().equals("type")){
				this.type = B.toString();
			}else if(A.toString().equals("verb")){
				this.verb = B.toString();
			}else if(A.toString().equals("key")){
				this.key = B.toString();
			}else if(A.toString().equals("event_time")){
				this.event_time = B.toString();
			}else if(A.toString().equals("customer_id")){
				this.customer_id = B.toString();
			}else if(A.toString().equals("last_name")){
				this.last_name = B.toString();
			}else if(A.toString().equals("adr_city")){
				this.adr_city = B.toString();
			}else if(A.toString().equals("adr_state")) {
				this.adr_state = B.toString();
			}
			//else if(A.toString().equals("tags")) {}
			else if(A.toString().equals("image_id")) {
				this.image_id = B.toString();
			}else if(A.toString().equals("camera_make")) {
				this.camera_make = B.toString();
			}else if(A.toString().equals("camera_model")) {
				this.camera_model = B.toString();
			}else if(A.toString().equals("order_id")) {
				this.order_id = B.toString();
			}else if(A.toString().equals("total_amount")) {
				String amount = B.toString().substring(0, B.toString().length() - 3);
				System.out.println("amount " + amount);
				this.total_amount = Double.parseDouble(amount);
			}			
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAdr_city() {
		return adr_city;
	}

	public void setAdr_city(String adr_city) {
		this.adr_city = adr_city;
	}

	public String getAdr_state() {
		return adr_state;
	}

	public void setAdr_state(String adr_state) {
		this.adr_state = adr_state;
	}

	public HashMap<String, String> getTags() {
		return tags;
	}

	public void setTags(HashMap<String, String> tags) {
		this.tags = tags;
	}

	public String getCamera_make() {
		return camera_make;
	}

	public void setCamera_make(String camera_make) {
		this.camera_make = camera_make;
	}

	public String getCamera_model() {
		return camera_model;
	}

	public void setCamera_model(String camera_model) {
		this.camera_model = camera_model;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	

}
