package com.university.universitymanagement.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		super("Non c'è l'utente con ID: " + id);
	}
	

}
