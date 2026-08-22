package com.project.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.studentmanagementsystem.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//check if username exists, because username is meant to be unique
	boolean existsByUsername(String username);

}
