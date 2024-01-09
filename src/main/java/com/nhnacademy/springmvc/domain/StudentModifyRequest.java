package com.nhnacademy.springmvc.domain;
import lombok.Value;

@Value
public class StudentModifyRequest {
    String name;
    String email;
    int score;
    String comment;
}
