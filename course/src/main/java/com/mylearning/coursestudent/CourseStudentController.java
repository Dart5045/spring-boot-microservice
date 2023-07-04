package com.mylearning.coursestudent;


import com.mylearning.clients.coursestudent.CourseStudentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/v1/courses-students")
public class CourseStudentController {

    private final CourseStudentServiceImp courseStudentService;

    public CourseStudentController(CourseStudentServiceImp courseStudentService) {
        this.courseStudentService = courseStudentService;
    }


    @GetMapping("/{studentId}/{courseId}")
    public CourseStudentResponse addCourseStudent(@PathVariable("studentId") Integer studentId,
                                                  @PathVariable("courseId") Integer courseId)
    {
        Boolean res = courseStudentService.addCourseStudent(courseId, studentId);
        return new  CourseStudentResponse(res);
    }
}
