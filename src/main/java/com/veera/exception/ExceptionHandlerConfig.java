package com.veera.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler to handle the custom exceptions
 * 
 * @author Veera.Shankara
 *
 */
@RestControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

	/**
	 * Custom Exception handler method to handle if the service not found
	 * 
	 * @param InvalidInputException
	 * @return ResponseEntity<ErrorDetails>
	 */
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorDetails> handleComicServiceNotFoundException(InvalidInputException e) {
		ErrorDetails error = new ErrorDetails(601, e.getMsg());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Custom Exception handler method to handle if the service not found
	 * 
	 * @param PromoNotFoundException
	 * @return ResponseEntity<ErrorDetails>
	 */
	@ExceptionHandler(PromoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlePromoCodeNotFoundException(PromoNotFoundException e) {
		ErrorDetails error = new ErrorDetails(602, e.getMsg());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Custom Exception handler method to handle if the service not found
	 * 
	 * @param NoDataFoundException
	 * @return ResponseEntity<ErrorDetails>
	 */
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoDataFoundException(NoDataFoundException e) {
		ErrorDetails error = new ErrorDetails(603, e.getMsg());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
