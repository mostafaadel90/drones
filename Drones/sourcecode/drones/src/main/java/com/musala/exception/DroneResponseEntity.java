/**
 * 
 */
package com.musala.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mostafaadel
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DroneResponseEntity{

	
	String message;
	Date timeStamp;

	public DroneResponseEntity(String message, Date timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	


}
