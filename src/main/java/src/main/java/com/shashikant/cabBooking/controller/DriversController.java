package src.main.java.com.shashikant.cabBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.shashikant.cabBooking.model.Driver;
import src.main.java.com.shashikant.cabBooking.serivce.DriverService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DriversController {
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/drivers")
	public ResponseEntity<List<Driver>> getAllDrivers() {
		List<Driver> drivers = driverService.getAllDrivers();
		return new ResponseEntity<List<Driver>>(drivers, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriver(@Validated @RequestBody Driver driver) {
		Driver createdDriver = driverService.createDriver(driver);
		return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
	}

	@PutMapping("/drivers")
	public ResponseEntity<Driver>  updateDriver(@Validated @RequestBody Driver driver) {
		Driver updatedDriver = driverService.updateDriver(driver);
		return new ResponseEntity<>(updatedDriver, HttpStatus.CREATED);		
	}
}
