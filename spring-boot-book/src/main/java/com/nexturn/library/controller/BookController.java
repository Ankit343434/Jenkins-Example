package com.nexturn.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.library.entity.Book;
import com.nexturn.library.service.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = {"http://localhost:3000"})
public class BookController {
	@Autowired
	BookService service;
	
	@PostMapping
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		service.addBook(book);
		return new ResponseEntity<String>("inserted",HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<String> editBook(@RequestBody Book book) {
		service.editBook(book);
		return new ResponseEntity<String>("edited",HttpStatus.OK);
	}
	@DeleteMapping("/{bookid}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookid) {
		service.removeBook(bookid);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		//HttpSession session = request.getSession();
		//Object obj = session.getAttribute("loginstatus");
	//	System.out.println("session = "+ obj);
		//if(obj==null)
		//	return new ResponseEntity<String>("Login to access",HttpStatus.OK);
		List<Book> bookList = service.getAllBooks();
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
	}
	@GetMapping("/byauthor/{author}")
	public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author){
		List<Book> bookList = service.getBooksByAuthor(author);
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
	}
	
	@GetMapping("/bytitlelike/{title}")
	public ResponseEntity<List<Book>> getBooksByTitleLike(@PathVariable String title){
		List<Book> bookList = service.getBooksByTitleLike(title);
		return new ResponseEntity<List<Book>>(bookList,HttpStatus.OK);
	}
		
	@GetMapping("/{bookid}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookid){
		Book book = service.getBookById(bookid);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	
}
