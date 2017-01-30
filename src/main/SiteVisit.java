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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((page_id == null) ? 0 : page_id.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		SiteVisit other = (SiteVisit) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (event_time == null) {
			if (other.event_time != null)
				return false;
		} else if (!event_time.equals(other.event_time))
			return false;
		if (page_id == null) {
			if (other.page_id != null)
				return false;
		} else if (!page_id.equals(other.page_id))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SiteVisit [page_id=" + page_id + ", event_time=" + event_time + ", customer_id=" + customer_id
				+ ", tags=" + tags + "]";
	}

	
}
