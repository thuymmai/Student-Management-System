package com.project.sms.service.impl;

import com.project.sms.model.Users;
import com.project.sms.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    private UsersRepository usersRepository;

    //applied constructor injection to give an object to UsersRepository class
    //pass UsersRepository usersRepository above
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //create a method in repository
        //name of domain class is Users
        Users users = usersRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Invalid username"));

        // check for username, password, and whether user is active
        return User.withUsername(username).password(users.getPassword())
                .disabled(!users.isActive())
                .build();

    }
}
