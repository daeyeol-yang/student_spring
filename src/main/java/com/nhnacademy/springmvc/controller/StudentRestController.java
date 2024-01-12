package com.nhnacademy.springmvc.controller;


import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    private final StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
         Student stduentResult=  studentRepository.register(student.getName(),student.getEmail(),student.getScore(),student.getComment());
         return new ResponseEntity<>(stduentResult, HttpStatus.ACCEPTED);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId)
    {
        return new ResponseEntity<>( studentRepository.getStudent(studentId),HttpStatus.ACCEPTED);
    }



    @PutMapping("/students/{studentId}/modify")
    public ResponseEntity<Student> modifyStudent(@PathVariable("studentId") Long studentId,
                                                 @RequestBody Student modifiedStudent) {
        Student existingStudent = studentRepository.getStudent(studentId);

        if (existingStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingStudent.setName(modifiedStudent.getName());
        existingStudent.setEmail(modifiedStudent.getEmail());
        existingStudent.setScore(modifiedStudent.getScore());
        existingStudent.setComment(modifiedStudent.getComment());

        return new ResponseEntity<>(existingStudent, HttpStatus.OK);
    }



}
