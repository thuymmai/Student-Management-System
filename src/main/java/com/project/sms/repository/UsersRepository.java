package com.project.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sms.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    //check if username exists, because username is meant to be unique
    boolean existsByUsername(String username);

}
