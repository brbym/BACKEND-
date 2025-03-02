package com.project.questapp.controllers;


import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserControllers {
	
	private UserService userService ;
	
	public  UserControllers(UserService userService) {
		this.userService(userService);
	}

	
	private void userService(UserService userService2) {
		// TODO Auto-generated method stub
		
	}



	@GetMapping
	public List<User> getAllUsers(){
	  return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}") 
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return userService.getOneUser(userId);
		
	}
	
	@PutMapping("/{userId}")
	public User uptadeOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.uptadeOneUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(null);
	}
	
}