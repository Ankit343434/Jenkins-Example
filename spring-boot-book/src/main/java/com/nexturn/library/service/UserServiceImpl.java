package com.nexturn.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.library.entity.User;
import com.nexturn.library.exceptions.UserNotFoundException;
import com.nexturn.library.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public void addUser(User user) {
		repo.save(user);		
	}

	@Override
	public User userValidation(User user) {
		int sum = repo.sumOfNumbers(30,40);
		System.out.println("procedure sum : "+sum); 
		Optional<User> opUser= repo.validateUser(user.getUsername(), user.getPassword());
		if(opUser.isEmpty())
			throw new UserNotFoundException();
		return opUser.get();
	}

}
