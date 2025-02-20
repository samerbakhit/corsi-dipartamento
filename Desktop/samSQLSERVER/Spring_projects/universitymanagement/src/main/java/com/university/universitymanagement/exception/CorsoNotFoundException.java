package com.university.universitymanagement.exception;

public class CorsoNotFoundException extends RuntimeException {

	public CorsoNotFoundException(Long id) {
		super("Non ce il corso con ID : "+id);
	}
	

}
