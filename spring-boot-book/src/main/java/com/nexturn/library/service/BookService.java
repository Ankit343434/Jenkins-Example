package com.nexturn.library.service;

import java.util.List;

import com.nexturn.library.entity.Book;
import com.nexturn.library.exceptions.BookIdAlreadyExistsException;
import com.nexturn.library.exceptions.BookNotFoundException;

public interface BookService {
	void addBook(Book book) throws BookIdAlreadyExistsException;
	void editBook(Book book);
	void removeBook(int bookId);
	List<Book> getAllBooks();
	Book getBookById(int bookId) throws BookNotFoundException;
	List<Book> getBooksByAuthor(String author);
	List<Book> getBooksByTitleLike(String title);
	
}
