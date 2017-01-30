package main;

import java.util.Arrays;

public class Image {

	private String image_id;
	private String event_time;
	private String customer_id;
	private String camera_make;
	private String camera_model;
	
		
	public Image(String image_id, String event_time, String customer_id, String camera_make, String camera_model) {
		super();
		this.image_id = image_id;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.camera_make = camera_make;
		this.camera_model = camera_model;
	}

	public Image(Event e) {
		// TODO Auto-generated constructor stub
		this.image_id = e.getKey();
		this.event_time = e.getEvent_time();
		this.customer_id = e.getCustomer_id();
		this.camera_make = e.getCamera_make();
		this.camera_model = e.getCamera_model();		
	}

	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((camera_make == null) ? 0 : camera_make.hashCode());
		result = prime * result + ((camera_model == null) ? 0 : camera_model.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((image_id == null) ? 0 : image_id.hashCode());
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
		Image other = (Image) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Image [image_id=" + image_id + ", event_time=" + event_time + ", customer_id=" + customer_id
				+ ", camera_make=" + camera_make + ", camera_model=" + camera_model + "]";
	}
	
	
}