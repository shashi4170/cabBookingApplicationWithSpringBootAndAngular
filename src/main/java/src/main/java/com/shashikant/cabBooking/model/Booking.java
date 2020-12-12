package src.main.java.com.shashikant.cabBooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	private long orderNumber;
	private String customerName;
	private Double customerLatitude;
	private Double customerLongitude;
	private String driverName;

	protected Booking() {
		
	}
	
	public Booking(long orderNumber, String customerName, Double customerLatitude, Double customerLongitude, String driverName) {
		super();
		this.orderNumber = orderNumber;
		this.customerName = customerName;
		this.customerLatitude = customerLatitude;
		this.customerLongitude = customerLongitude;
	}


	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getCustomerLatitude() {
		return customerLatitude;
	}

	public void setCustomerLatitude(Double customerLatitude) {
		this.customerLatitude = customerLatitude;
	}

	public Double getCustomerLongitude() {
		return customerLongitude;
	}

	public void setCustomerLongitude(Double customerLongitude) {
		this.customerLongitude = customerLongitude;
	}

	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "Booking [orderNumber=" + orderNumber + ", customerName=" + customerName + ", customerLatitude=" + customerLatitude
				+ ", customerLangitude=" + customerLongitude + ", driverName=" + driverName + "]";
	}
}
