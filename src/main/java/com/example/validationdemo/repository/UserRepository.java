package com.example.validationdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validationdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserId(int userId);
	

}
