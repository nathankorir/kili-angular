package com.kilifarm.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kilifarm.model.User;
import com.kilifarm.repository.UserRepository;
import com.kilifarm.service.UserService;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public Map<String, String> register(@RequestBody User user) {
		User userExists = userService.findByPhone(user.getPhone());
		if (userExists != null) {
			return Collections.singletonMap("error", "There is already a user registered with the phone number provided");
		}else {
		userService.saveUser(user);
		}
		return Collections.singletonMap("success","Registered Successfully");
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
