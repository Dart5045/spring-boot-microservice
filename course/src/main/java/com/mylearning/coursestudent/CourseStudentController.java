package com.mylearning.coursestudent;


import com.mylearning.DTO.CourseDTO;
import com.mylearning.DTO.CourseStudentResponse;
import com.mylearning.course.CourseServiceImp;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("app/v1/coursesstudents")
public class CourseStudentController {

    private final CourseStudentService courseStudentService;


    @GetMapping("{studentId}/{courseId}")
    public CourseStudentResponse addCourseStudent(@PathVariable("studentId") Integer studentId,
                                                  @PathVariable("courseId") Integer courseId)
    {
        Boolean res = courseStudentService.addCourseStudent(courseId, studentId);
        return new  CourseStudentResponse(res);
    }
}
