package com.sprint1.project.exception;

public class AdminNotFoundException extends Exception {
	public AdminNotFoundException() {

	}

	public AdminNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -55L;
}