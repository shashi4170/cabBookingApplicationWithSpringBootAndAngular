package src.main.java.com.shashikant.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.main.java.com.shashikant.cabBooking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
