package com.nexturn.library.service;

import com.nexturn.library.entity.User;

public interface UserService {
	void addUser(User user);
	User userValidation(User user);
}
