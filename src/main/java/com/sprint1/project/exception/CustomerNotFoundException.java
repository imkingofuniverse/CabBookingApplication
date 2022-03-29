package com.sprint1.project.exception;

public class CustomerNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public CustomerNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public CustomerNotFoundException() {
		super();
	}
}
