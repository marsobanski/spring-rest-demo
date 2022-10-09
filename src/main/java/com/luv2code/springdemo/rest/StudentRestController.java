package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void populateStudents() {
        students = new ArrayList<>();
        students.add(new Student("Marian", "Kowalski"));
        students.add(new Student("Henryk", "Kania"));
        students.add(new Student("Karina", "Sztoll"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int  studentId) {
        if (studentId >= students.size() - 1 || studentId < 0) {
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }
        return students.get(studentId);
    }
}
