package main;

public class Order {
	private String order_id;
	private String event_time;
	private String customer_id;
	private double total_amount;
	
	public Order(String order_id, String event_time, String customer_id, double total_amount) {
		super();
		this.order_id = order_id;
		this.event_time = event_time;
		this.customer_id = customer_id;
		this.total_amount = total_amount;
	}

	public Order(Event e) {
		// TODO Auto-generated constructor stub
		this.order_id = e.getKey();
		this.event_time = e.getEvent_time();
		this.customer_id = e.getCustomer_id();
		this.total_amount = e.getTotal_amount();
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	public String getCurstomer_id() {
		return customer_id;
	}

	public void setCurstomer_id(String customer_id) {
		this.customer_id = customer_id;
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
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((event_time == null) ? 0 : event_time.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Order other = (Order) obj;
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
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (Double.doubleToLongBits(total_amount) != Double.doubleToLongBits(other.total_amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", event_time=" + event_time + ", customer_id=" + customer_id
				+ ", total_amount=" + total_amount + "]";
	}
	
}
