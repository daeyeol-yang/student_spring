package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {

    private long id;
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private int score;
    @Setter
    private String comment;

    public Student() {
    }

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
