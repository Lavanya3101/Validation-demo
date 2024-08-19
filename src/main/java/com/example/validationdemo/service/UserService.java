package com.example.validationdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.validationdemo.dto.UserRequest;
import com.example.validationdemo.entity.User;
import com.example.validationdemo.entity.UserRoles;
import com.example.validationdemo.exception.UserNotFoundException;
import com.example.validationdemo.repository.UserRepository;
import com.example.validationdemo.repository.UserRolesRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRolesRepository userRolesRepository;
	public User saveUser(UserRequest userRequest) {
//		User user=User.build(userRequest.getName(),userRequest.getEmail());
//		which takes a UserRequest DTO, converts it into a User entity, and saves it to the database.
		User user=new User(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
		return userRepository.save(user);
	}
	
	public List<User>getAllUSers(){
		return userRepository.findAll();
	}
//	public Optional<User>  getUserById(int id) {
//		return userRepository.findById(id);
//	}
	public User getUserById(int userId) throws UserNotFoundException{
		User user= userRepository.findByUserId(userId);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("User not found with id:"+userId);
		}
	}
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User"+id+"deleted successfully";
	}

	public String addUserRoles(UserRoles userRoles) {
		userRoles.setPassword(passwordEncoder.encode(userRoles.getPassword()));
		userRolesRepository.save(userRoles);
		return "USer roles added to system";
	}
	
	

}
