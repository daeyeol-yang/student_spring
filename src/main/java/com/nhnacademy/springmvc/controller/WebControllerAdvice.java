package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {


        model.addAttribute("exception", ex);
        return "error";
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleStdudentNotFoundExeption(StudentNotFoundException ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }

    @ExceptionHandler(ValidationFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleValidationFailedException(ValidationFailedException ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }

}
