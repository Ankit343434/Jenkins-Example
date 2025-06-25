package com.nexturn.library.exceptions;

@SuppressWarnings("serial")
public class BookIdAlreadyExistsException extends RuntimeException{
	public BookIdAlreadyExistsException() {
		super("Book id is already exists..");
	}
}
