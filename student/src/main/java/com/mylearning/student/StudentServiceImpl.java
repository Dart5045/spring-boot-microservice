package com.mylearning.student;

import com.mylearning.DTO.StudentRegistrationRequestDTO;
import com.mylearning.amqp.RabbitMQMessageProducer;
import com.mylearning.clients.coursestudent.CourseStudentClient;
import com.mylearning.clients.coursestudent.CourseStudentResponse;
import com.mylearning.clients.notification.NotificationClient;
import com.mylearning.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final CourseStudentClient courseStudentClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public StudentServiceImpl(StudentRepository studentRepository, CourseStudentClient courseStudentClient, RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.studentRepository = studentRepository;
        this.courseStudentClient = courseStudentClient;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
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
        rabbitMQMessageProducer.publish(
                notification,
                "internal.exchange",
                "internal.notification.routing-key"
        );
        CourseStudentResponse courseStudentResponse = courseStudentClient.addCourseStudent(student.getId(), 1);
    }
}
