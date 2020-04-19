package com.example.demo.user;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.UserHardCodedService;;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;

	
	/*
	 * @GetMapping("") public List<User> getUsers() { return
	 * userRepository.getAllUsers(); }
	 */
	 

	
	/*
	 * @GetMapping("/{id}") public Optional<User> getUser(@PathVariable String id) {
	 * int userId = Integer.parseInt(id); return userRepository.findById(userId); }
	 */
	 

	
	/*
	 * @PostMapping("") public User createUser(@RequestBody User user) { return
	 * userRepository.createUser(user); }
	 */
	 
	
	
	  @GetMapping("") public List<User> getUsers() { return (List<User>)
	  userRepository.findAll(); }
	  
	  @PostMapping("") public User createUser(@RequestBody User user) {
	  userRepository.save(user); return user; }
	 
}
