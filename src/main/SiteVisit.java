package main;

import java.util.Arrays;
import java.util.HashMap;

public class SiteVisit {
	private String page_id;
	private String event_time;
	private String customer_id;
	private HashMap<String, String> tags;
	
	public SiteVisit(String page_id, String event_time, String customer_id, HashMap<String, String> tags) {
		super();
		this.page_id = page_id;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.tags = tags;
	}

	public SiteVisit(Event e) {
		// TODO Auto-generated constructor stub
		this.page_id = e.getKey();
		this.event_time = e.getEvent_time();
		this.customer_id = e.getCustomer_id();
		this.tags = e.getTags();
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
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

	public HashMap<String, String> getTags() {
		return tags;
	}

	public void setTags(HashMap<String, String> tags) {
		this.tags = tags;
	}

	
	
}
