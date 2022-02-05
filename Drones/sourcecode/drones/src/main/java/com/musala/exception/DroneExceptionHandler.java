package com.musala.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ControllerAdvice
public class DroneExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<DroneResponseEntity> handleAllException(Exception ex, WebRequest request) {
		ex.printStackTrace();
		DroneResponseEntity droneResponseException = new DroneResponseEntity("General Error", new Date());
		return new ResponseEntity<>(droneResponseException, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(DroneBadRequestException.class)
	public final ResponseEntity<DroneResponseEntity> handleBadrequestException(Exception ex, WebRequest request) {
		
		DroneResponseEntity droneResponseException = new DroneResponseEntity(ex.getMessage(), new Date());
		return new ResponseEntity<>(droneResponseException, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(DroneNotFoundException.class)
	public final ResponseEntity<DroneResponseEntity> handleResourceNotFoundException(Exception ex, WebRequest request) {
		
		DroneResponseEntity droneResponseException = new DroneResponseEntity(ex.getMessage(), new Date());
		return new ResponseEntity<>(droneResponseException, HttpStatus.NOT_FOUND);
		
	}
}
