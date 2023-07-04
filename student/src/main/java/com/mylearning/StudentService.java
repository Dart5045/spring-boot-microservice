package com.mylearning;

import com.mylearning.DTO.StudentRegistrationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public void registerStudent(StudentRegistrationRequestDTO studentRequest);

}
