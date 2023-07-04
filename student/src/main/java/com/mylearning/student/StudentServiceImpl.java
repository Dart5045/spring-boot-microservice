package com.mylearning.student;

import com.mylearning.DTO.StudentRegistrationRequestDTO;
import com.mylearning.clients.coursestudent.CourseStudentClient;
import com.mylearning.clients.coursestudent.CourseStudentResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseStudentClient courseStudentClient;

    public StudentServiceImpl(StudentRepository studentRepository, CourseStudentClient courseStudentClient) {
        this.studentRepository = studentRepository;
        this.courseStudentClient = courseStudentClient;
    }

    @Override
    public void registerStudent(StudentRegistrationRequestDTO studentRequest) {
        Student student = Student.builder()
                .firstName( studentRequest.firstName())
                .lastName( studentRequest.lastName())
                .email( studentRequest.email())
                .build();
        //To do check if email valid
        studentRepository.saveAndFlush(student);

        CourseStudentResponse courseStudentResponse = courseStudentClient.addCourseStudent(student.getId(), 1);
    }
}
