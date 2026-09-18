package com.project.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sms.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    //check if username exists, because username is meant to be unique
    boolean existsByUsername(String username);

    Optional<Users> findByUsername(String username);

}
