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

        System.out.println("me han llamado");

        CourseStudent courseStudent = CourseStudent
                .builder()
                .studentId(studentId)
                .id(courseId)
                .build();
        courseStudentRepository.save(courseStudent);
        return true;
    }
}
