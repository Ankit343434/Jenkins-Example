package com.nexturn.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexturn.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByAuthor(String author);
	List<Book> findByTitleLike(String author);
	@Query(value = "select max(b.bookId) from Book b ")
	Optional<Integer> getMaxId(); 
}
