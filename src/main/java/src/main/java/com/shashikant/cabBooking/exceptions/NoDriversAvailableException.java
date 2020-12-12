package src.main.java.com.shashikant.cabBooking.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDriversAvailableException extends RuntimeException {
	public NoDriversAvailableException(String message) {
		super(message);
	}
	public NoDriversAvailableException(){
		
	}
}
