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
	
	
}