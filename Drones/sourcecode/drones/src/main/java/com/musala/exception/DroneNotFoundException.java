/**
 * 
 */
package com.musala.exception;

/**
 * @author mostafaadel
 *
 */
public class DroneNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7579247887567706202L;

	String message;

	
	public DroneNotFoundException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
