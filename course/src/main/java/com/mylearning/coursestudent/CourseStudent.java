package com.mylearning.coursestudent;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseStudent {
    @Id
    @SequenceGenerator(
            name = "course_student_id_sequence",
            sequenceName = "course_student_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_student_id_sequence"
    )
    private Integer id;

    private Integer studentId;
}