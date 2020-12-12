package src.main.java.com.shashikant.cabBooking.serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.shashikant.cabBooking.model.Driver;
import src.main.java.com.shashikant.cabBooking.repository.DriverRepository;


@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	
	public List<Driver> getAllDrivers(){		
		List<Driver> driverList = driverRepository.findAll();
		if(driverList.size() > 0) {
			return driverList;
		}else {
			return new ArrayList<Driver>();
		}
	}
	
	public Driver createDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public Driver updateDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
}
