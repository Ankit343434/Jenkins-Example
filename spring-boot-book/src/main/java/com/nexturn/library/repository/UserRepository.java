package com.nexturn.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.nexturn.library.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer	>{
	@Query(value = "select u from User u where u.username= ?1 and u.password=?2")
	public Optional<User> validateUser(String username,String password);
	
	// for stored procedure call
	@Procedure(procedureName = "add_numbers")
	int sumOfNumbers(int x, int y);
}

