package com.project.sms.service.impl;

import com.project.sms.dto.CourseDTO;
import com.project.sms.repository.CourseRepository;
import com.project.sms.service.CourseService;
import org.modelmapper.ModelMapper;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;

    // created constructor
    CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;

    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        courseRepository.save(null);

        return null;
    }
}
