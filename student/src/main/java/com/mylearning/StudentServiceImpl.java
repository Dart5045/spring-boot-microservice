package com.mylearning;

import com.mylearning.DTO.StudentRegistrationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void registerStudent(StudentRegistrationRequestDTO studentRequest) {
        Student student = Student.builder()
                .firstName( studentRequest.firstName())
                .lastName( studentRequest.lastName())
                .email( studentRequest.email())
                .build();
        //To do check if email valid
        studentRepository.save(student);
    }
}
