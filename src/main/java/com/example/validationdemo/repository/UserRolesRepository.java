package com.example.validationdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validationdemo.entity.UserRoles;
@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{

	Optional<UserRoles> findByName(String username);

}
