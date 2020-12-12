package src.main.java.com.shashikant.cabBooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Driver {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Double latitude;
	private Double  longitude;
	private boolean isAvailable;
	private String customerName;
	
	@Transient
	private Double distance;
	

	protected Driver() {
		
	}
	
	public Driver(int id, String name, Double latitude, Double longitude, Double distance, String customerName) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.isAvailable = true;
		this.distance = distance;
		this.customerName = customerName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", isAvailable=" + isAvailable + ", customerName=" + customerName + ", distance=" + distance + "]";
	}

	
}
