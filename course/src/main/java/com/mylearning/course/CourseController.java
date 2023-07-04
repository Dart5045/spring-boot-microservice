package com.mylearning.course;


import com.mylearning.DTO.CourseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1/courses")
public class CourseController {
    private final CourseServiceImp courseService;

    public CourseController(CourseServiceImp courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void addCourse(@RequestBody CourseDTO courseRequest)
    {
        courseService.addCourse(courseRequest);
    }
}
