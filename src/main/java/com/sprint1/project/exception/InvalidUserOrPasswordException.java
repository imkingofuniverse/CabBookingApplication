package com.sprint1.project.exception;

public class InvalidUserOrPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserOrPasswordException(String msg) {
		super(msg);
	}
}