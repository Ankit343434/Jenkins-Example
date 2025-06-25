package com.nexturn.library.exceptions;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException() {
		super("Book not found ....");
	}
}
