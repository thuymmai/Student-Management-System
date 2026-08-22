package com.project.studentmanagementsystem.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.studentmanagementsystem.model.Users;
import com.project.studentmanagementsystem.repository.UsersRepository;

@Configuration // @Configuration is a class-level annotation indicating that an object is a source of bean definitions
public class DataInitializer {
	
	//insert data
	
	//Add @Bean annotation so system knows it is a Bean or a class
	@Bean
	CommandLineRunner loadSampleData(UsersRepository usersRepository, PasswordEncoder passwordEnconder) {
		
		//the return statement will lambda expression
		return args -> {
			if (!usersRepository.existByUsername("Admin")) {
				Users users = new Users();
				users.setUsername("Admin");
				users.setPassword(passwordEnconder.encode("admin@123"));
				users.setActive(true);
				
				//after that, we save the usersRepository
				usersRepository.save(users);				
			}
			
		};
		
	}

}
