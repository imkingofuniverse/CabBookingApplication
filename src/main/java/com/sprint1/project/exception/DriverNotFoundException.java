package com.sprint1.project.exception;

public class DriverNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public DriverNotFoundException(String msg) {
		super(msg);
	}
}