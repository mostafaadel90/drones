/**
 * 
 */
package com.musala.exception;

/**
 * @author mostafaadel
 *
 */
public class DroneBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2049119416099018005L;
	String message;

	
	public DroneBadRequestException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}
	
	
}
