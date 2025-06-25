package com.nexturn.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.library.entity.User;
import com.nexturn.library.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {
		service.addUser(user);
		return new ResponseEntity<String>("user created... ",HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<User> loginValidate(@RequestBody User user){
		User u = service.userValidation(user);
		//HttpSession session = request.getSession(true);
		//session.setAttribute("loginstatus", "YES");
		//System.out.println("session created");
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	@GetMapping("/logout")
	public String logout() {
		//HttpSession session = request.getSession();
		//System.out.println("from logut : "+session.getAttribute("loginstatus"));
		//session.invalidate();
	//	System.out.println("after invalidate : "+session.getAttribute("loginstatus"));
		return "Session invalidated";
	}
}
