package com.mylearning.student;


import com.mylearning.DTO.StudentRegistrationRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void registerStudent(@RequestBody StudentRegistrationRequestDTO studentRequest){
        studentService.registerStudent( studentRequest );
        log.info("blas{}", studentRequest);
    }
}
