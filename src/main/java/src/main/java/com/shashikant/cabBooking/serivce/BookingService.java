package src.main.java.com.shashikant.cabBooking.serivce;

import java.util.List;
import src.main.java.com.shashikant.cabBooking.model.Booking;

public interface BookingService {
	public List<Booking> getAllBookings();
	public Booking createBooking(Booking booking);
}
