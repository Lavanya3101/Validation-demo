package com.example.validationdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.validationdemo.dto.UserRequest;
import com.example.validationdemo.entity.User;
import com.example.validationdemo.entity.UserRoles;
import com.example.validationdemo.exception.UserNotFoundException;
import com.example.validationdemo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
  private UserService userService;
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
		
	}
	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUSers());
	}
	@GetMapping("/{userId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<User>getUserById(@PathVariable int userId) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	@DeleteMapping("/{userId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> deleteById(@PathVariable int userId){
		return ResponseEntity.ok(userService.deleteUserById(userId));
	}
	@PostMapping("/addUserRoles")
	public String addUserRoles(@RequestBody UserRoles userRoles) {
		return userService.addUserRoles(userRoles);
	}
}
