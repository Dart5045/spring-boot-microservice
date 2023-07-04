package com.mylearning.coursestudent;

import com.mylearning.DTO.CourseStudentDTO;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentServiceImp implements  CourseStudentService{
    private final CourseStudentRepository courseStudentRepository;

    public CourseStudentServiceImp(CourseStudentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    @Override
    public Boolean addCourseStudent(Integer courseId, Integer studentId) {
        CourseStudent courseStudent = CourseStudent
                .builder()
                .studentId(studentId)
                .id(courseId)
                .build();
        return true;
    }
}
