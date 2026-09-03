package com.project.sms.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.sms.model.Users;
import com.project.sms.repository.UsersRepository;

@Configuration // @Configuration is a class-level annotation indicating that an object is a source of bean definitions
public class DataInitializer {

    //insert data

    //Add @Bean annotation so system knows it is a Bean or a class
    @Bean
    CommandLineRunner loadSampleData(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {

        //the return statement will pass lambda expression
        return args -> {
            if (!usersRepository.existsByUsername("Admin")) {
                Users users = new Users();
                users.setUsername("Admin");
                users.setPassword(passwordEncoder.encode("admin@123")); //where I pass the actual password
                users.setActive(true);

                //after that, I save the usersRepository
                usersRepository.save(users);
            }

        };

    }

}
