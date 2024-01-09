package com.nhnacademy.springmvc.domain;

import lombok.Getter;

@Getter
public class Student {

    private long id;
    private String name;
    private String email;
    private int score;
    private String comment;

    public static Student create(Long id,String name, String email, int score, String comment){
        return new Student(id,name,email,score,comment);
    }

    public Student(Long id, String name, String email, int score, String comment) {
        this.id =id;
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }
}
