package com.mylearning.clients.coursestudent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("course")
public interface CourseStudentClient {

    @GetMapping("app/v1/courses-students/{studentId}/{courseId}")
    CourseStudentResponse addCourseStudent(@PathVariable("studentId") Integer studentId,
                                           @PathVariable("courseId") Integer courseId);
}
