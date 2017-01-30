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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adr_city == null) ? 0 : adr_city.hashCode());
		result = prime * result + ((adr_state == null) ? 0 : adr_state.hashCode());
		result = prime * result + ((camera_make == null) ? 0 : camera_make.hashCode());
		result = prime * result + ((camera_model == null) ? 0 : camera_model.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((image_id == null) ? 0 : image_id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((verb == null) ? 0 : verb.hashCode());
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
		Event other = (Event) obj;
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
		if (camera_make == null) {
			if (other.camera_make != null)
				return false;
		} else if (!camera_make.equals(other.camera_make))
			return false;
		if (camera_model == null) {
			if (other.camera_model != null)
				return false;
		} else if (!camera_model.equals(other.camera_model))
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
		if (image_id == null) {
			if (other.image_id != null)
				return false;
		} else if (!image_id.equals(other.image_id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (Double.doubleToLongBits(total_amount) != Double.doubleToLongBits(other.total_amount))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (verb == null) {
			if (other.verb != null)
				return false;
		} else if (!verb.equals(other.verb))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [type=" + type + ", verb=" + verb + ", key=" + key + ", event_time=" + event_time
				+ ", customer_id=" + customer_id + ", last_name=" + last_name + ", adr_city=" + adr_city
				+ ", adr_state=" + adr_state + ", tags=" + tags + ", image_id=" + image_id + ", camera_make="
				+ camera_make + ", camera_model=" + camera_model + ", order_id=" + order_id + ", total_amount="
				+ total_amount + "]";
	}	
}
