package com.nexturn.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.library.entity.Book;
import com.nexturn.library.exceptions.BookIdAlreadyExistsException;
import com.nexturn.library.exceptions.BookNotFoundException;
import com.nexturn.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepository repo;
	
	@Override
	public void addBook(Book book) {
		Optional<Book> optionalBook = repo.findById(book.getBookId());
		if(!optionalBook.isEmpty())
			throw new BookIdAlreadyExistsException();
		repo.save(book);
	}

	@Override
	public void editBook(Book book) {
		repo.save(book);		
	}

	@Override
	public void removeBook(int bookId) {
		repo.deleteById(bookId); 
	}

	@Override
	public List<Book> getAllBooks() {
		Optional<Integer> id = repo.getMaxId();	
		System.out.println("max id : "+id.get()); 
		return repo.findAll();
	}

	@Override
	public Book getBookById(int bookId) {
		Optional<Book> book = repo.findById(bookId);
		if(book.isEmpty())
			throw new BookNotFoundException();
		return book.get();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		List<Book> bookList = repo.findByAuthor(author);
		//if(bookList.isEmpty())
		
		return bookList;
	}

	@Override
	public List<Book> getBooksByTitleLike(String title) {
		List<Book> list = repo.findByTitleLike("%"+title+"%");
		return list;
	}
}
