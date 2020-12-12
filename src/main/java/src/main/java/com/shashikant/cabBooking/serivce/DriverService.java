package src.main.java.com.shashikant.cabBooking.serivce;

import java.util.List;
import src.main.java.com.shashikant.cabBooking.model.Driver;


public interface DriverService {
	
	public List<Driver> getAllDrivers();
	public Driver createDriver(Driver driver);
	public Driver updateDriver(Driver driver);
	
}
