package com.nexturn.library.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("User not found....");
	}
}
