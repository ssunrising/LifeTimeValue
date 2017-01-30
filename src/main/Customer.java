package main;

import java.util.Arrays;

public class Customer {
	private String customer_id;
	private String event_time;
	private String last_name;
	private String adr_city;
	private String adr_state;
	
	public Customer(String customer_id, String event_time, String last_name, String adr_city, String adr_state) {
		super();
		this.customer_id = customer_id;
		this.event_time = event_time;
		this.last_name = last_name;
		this.adr_city = adr_city;
		this.adr_state = adr_state;
	}

	public Customer(Event e) {
		// TODO Auto-generated constructor stub
		this.customer_id = e.getKey();
		this.event_time = e.getEvent_time();
		this.last_name = e.getLast_name();
		this.adr_city = e.getAdr_city();
		this.adr_state = e.getAdr_state();		
	}

	public String getCurstomer_id() {
		return customer_id;
	}

	public void setCurstomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adr_city == null) ? 0 : adr_city.hashCode());
		result = prime * result + ((adr_state == null) ? 0 : adr_state.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
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
		Customer other = (Customer) obj;
		if (adr_city == null) {
			if (other.adr_city != null)
				return false;
		} else if (!adr_city.equals(other.adr_city))
			return false;
		if (adr_state == null) {
			if (other.adr_state != null)
				return false;
		} else if (!adr_state.equals(other.adr_state))
			return false;
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
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", event_time=" + event_time + ", last_name=" + last_name
				+ ", adr_city=" + adr_city + ", adr_state=" + adr_state + "]";
	}

	
	

}
