package com.project.sms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // create a Bean for ModelMapper
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
