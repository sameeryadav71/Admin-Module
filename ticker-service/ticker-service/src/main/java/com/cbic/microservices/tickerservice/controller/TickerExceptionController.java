package com.cbic.microservices.tickerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cbic.microservices.tickerservice.exception.IOException;
import com.cbic.microservices.tickerservice.exception.NoSuchAlgorithmException;
import com.cbic.microservices.tickerservice.exception.RequestNotValid;
import com.cbic.microservices.tickerservice.exception.SaveFailureException;
import com.cbic.microservices.tickerservice.exception.TickerDataNotFoundException;

@ControllerAdvice
public class TickerExceptionController {
	
	@ExceptionHandler(value = TickerDataNotFoundException.class)
	   public ResponseEntity<Object> exception(TickerDataNotFoundException exception) {
	      return new ResponseEntity<>("Request data not found", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = RequestNotValid.class)
	   public ResponseEntity<Object> exception(RequestNotValid exception) {
	      return new ResponseEntity<>("Request parameter is not valid", HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = IOException.class)
	   public ResponseEntity<Object> exception(IOException exception) {
	      return new ResponseEntity<>("Checksum generated is not valid", HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = NoSuchAlgorithmException.class)
	   public ResponseEntity<Object> exception(NoSuchAlgorithmException exception) {
	      return new ResponseEntity<>("Checksum algorithm is not valid", HttpStatus.BAD_REQUEST);
	   }
	
	@ExceptionHandler(value = SaveFailureException.class)
	   public ResponseEntity<Object> exception(SaveFailureException exception) {
	      return new ResponseEntity<>("Error while saving details", HttpStatus.METHOD_FAILURE);
	   }
}
