package src.main.java.com.shashikant.cabBooking.serivce;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.shashikant.cabBooking.exceptions.DriverNotFoundException;
import src.main.java.com.shashikant.cabBooking.exceptions.NoDriversAvailableException;
import src.main.java.com.shashikant.cabBooking.model.Booking;
import src.main.java.com.shashikant.cabBooking.model.Driver;
import src.main.java.com.shashikant.cabBooking.repository.BookingRepository;


@Service
public class BookingServiceImpl implements BookingService {
	public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private DriverService driverService;
	
	
	public List<Booking> getAllBookings(){		
		List<Booking> bookings = bookingRepository.findAll();
		if(bookings.size() > 0) {
			return bookings;
		}else {
			return new ArrayList<Booking>();
		}
	}


	@Override
	public Booking createBooking(Booking booking) {
		final Driver bookedDriver = bookDriver(booking.getCustomerLatitude(), booking.getCustomerLongitude()); 
		bookedDriver.setAvailable(false);
		bookedDriver.setCustomerName(booking.getCustomerName());
		booking.setDriverName(bookedDriver.getName());
		Booking bookingDetails = bookingRepository.save(booking);
		driverService.updateDriver(bookedDriver);
		return bookingDetails;
	}
	
	
	public Driver bookDriver(Double customerLatitude, Double customerLongitude) {
		final List<Driver> availableDrivers = fetchAvailableDrivers();
		final List<Driver> nearestAvailableDrivers = fetchSortedNearestAvailableDrivers(customerLatitude, customerLongitude, availableDrivers);
	    return nearestAvailableDrivers.get(0);
	}
	
	public List<Driver> fetchSortedNearestAvailableDrivers(Double customerLatitude, Double customerLongitude, List<Driver> availableDrivers){		
		List<Driver> sortedNearestAvailableDrivers = new ArrayList<>();
		for (Driver driver : availableDrivers) {
	      if (isNearbyDriver(customerLatitude, customerLongitude, driver)) {
	    	  sortedNearestAvailableDrivers.add(driver);
	      }
	    }
	    sortedNearestAvailableDrivers.sort((Driver d1, Driver d2)->d1.getDistance().compareTo(d2.getDistance())); 
	    
	    if(sortedNearestAvailableDrivers.isEmpty()){
	    	throw new DriverNotFoundException();
	    }
	    return sortedNearestAvailableDrivers;
	}
	
	public List<Driver> fetchAvailableDrivers(){
		List<Driver> availableDrivers = driverService.getAllDrivers().stream()
		            .filter(driver -> driver.isAvailable())
		            .collect(Collectors.toList());
		if(availableDrivers.isEmpty()){
			throw new NoDriversAvailableException();
		}
		return availableDrivers;
	}

	public boolean isNearbyDriver(Double customerLatitude, Double customerLongitude, Driver driver) {
		
		Double distance = sqrt( pow(customerLatitude - driver.getLatitude(), 2) + pow(customerLongitude - driver.getLongitude(), 2));
		driver.setDistance(distance);
	    return distance <= MAX_ALLOWED_TRIP_MATCHING_DISTANCE;
	}
}	
