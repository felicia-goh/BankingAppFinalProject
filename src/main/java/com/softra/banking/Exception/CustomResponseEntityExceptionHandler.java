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
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "User not found", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Account not found", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountLockedException.class)
	public final ResponseEntity<Object> handleAccountLockedException(AccountLockedException ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Account locked", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(PayeeNotFoundException.class)
	public final ResponseEntity<Object> handlePayeeNotFoundException(PayeeNotFoundException ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Payee not found", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Validation failed", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.BAD_REQUEST);
	}
	

}
