package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentModifyRequest;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")

public class StudentController {

    private final StudentRepository studentRepository;
    private final String YES ="yes";

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        Student student = studentRepository.getStudent(studentId);

        if(Objects.isNull(student)){
            throw new StudentNotFoundException();
        }
        return student;

    }

    @GetMapping("/{studentId}")
    public String viewStudent(@ModelAttribute Student student, @RequestParam(name="hideScore", required = false) String hideScore , Model model){
    if(YES.equals(hideScore)) {

            model.addAttribute("hideScore", true);
        }
        model.addAttribute("student",student);

        return "studentView";
    }

    @GetMapping("{studentId}/modify")
    public String stdentModifyForm(){return "studentModify";}

    @PostMapping("{studentId}/modify")
    public String modifyStudent(@ModelAttribute Student student,
                                @Valid @ModelAttribute StudentModifyRequest studentModifyRequest,
                                BindingResult bindingResult,
                                ModelMap modelMap){
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        student.setName(studentModifyRequest.getName());
        student.setEmail(studentModifyRequest.getEmail());
        student.setScore(studentModifyRequest.getScore());
        student.setComment(studentModifyRequest.getComment());

        modelMap.addAttribute("student", student);
        return "studentView";
    }



}
