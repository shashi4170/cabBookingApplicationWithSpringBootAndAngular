package src.main.java.com.shashikant.cabBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.shashikant.cabBooking.model.Booking;
import src.main.java.com.shashikant.cabBooking.serivce.BookingService;

@RestController
public class BookingsController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> bookings = bookingService.getAllBookings();
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		System.out.println(booking);
		Booking createdBooking = bookingService.createBooking(booking);
		return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);	
	}
}
