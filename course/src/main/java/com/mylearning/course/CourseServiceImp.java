package com.mylearning.course;

import com.mylearning.DTO.CourseDTO;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course course = Course.builder()
                .name(courseDTO.name())
                .build();
        courseRepository.save(course);
    }
}
