package com.mylearning.coursestudent;

import com.mylearning.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Integer> {
}
