package com.mylearning.student;

import com.mylearning.DTO.StudentRegistrationRequestDTO;
import com.mylearning.clients.coursestudent.CourseStudentClient;
import com.mylearning.clients.coursestudent.CourseStudentResponse;
import com.mylearning.clients.notification.NotificationClient;
import com.mylearning.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseStudentClient courseStudentClient;

    private final NotificationClient notificationClient;

    public StudentServiceImpl(StudentRepository studentRepository, CourseStudentClient courseStudentClient, NotificationClient notificationClient) {
        this.studentRepository = studentRepository;
        this.courseStudentClient = courseStudentClient;
        this.notificationClient = notificationClient;
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

        NotificationRequest notification = new NotificationRequest(
                student.getId(),
                studentRequest.email(),
                "Hi %s, welcome to My-Learning"
        );;
        notificationClient.send(notification);

        CourseStudentResponse courseStudentResponse = courseStudentClient.addCourseStudent(student.getId(), 1);
    }
}
