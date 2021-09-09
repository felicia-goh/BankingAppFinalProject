package com.softra.banking.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// spring bean which handles all exceptions
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Exception occurred", ex.getMessage());
		// returns error message as a json, converted by Jackson api
		return new ResponseEntity(cer,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CustomerNotFoundException ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "User not found", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Validation failed", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.BAD_REQUEST);
	}
	

}
