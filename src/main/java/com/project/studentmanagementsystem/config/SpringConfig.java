package com.project.studentmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //implement @EnableWebSecurity to let Spring know I want to use Spring Security features
public class SpringConfig {
	
	//implement the interface named PasswordEncoder then name it passwordEnconder
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		
		//whatever password I type in, it will be encrypted by the BCryptPasswordEncoder
		//then call the PasswordEncoder method in DataInitializer.java
		return new BCryptPasswordEncoder();
	}

}
