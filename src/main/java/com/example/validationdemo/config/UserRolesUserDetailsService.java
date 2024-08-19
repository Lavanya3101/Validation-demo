package com.example.validationdemo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.validationdemo.entity.UserRoles;
import com.example.validationdemo.repository.UserRolesRepository;

public class UserRolesUserDetailsService implements UserDetailsService {
@Autowired
	private UserRolesRepository userRolesRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserRoles> userRoles=userRolesRepository.findByName(username);
		return userRoles.map(UserRolesUserDetails::new).orElseThrow(()->new UsernameNotFoundException("username not found"+username));
	}

}
