package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class StudentRepositoryImpl implements StudentRepository {

    private final Map<Long, Student> studentMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);



    @Override
    public boolean exists(long id) {
        return studentMap.containsKey(id);

    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        long id = idGenerator.getAndIncrement();
       Student student = Student.create(id,name,email,score,comment);
       studentMap.put(id, student);

        return student;
    }

    @Override
    public Student getStudent(long id) {
        return exists(id) ? studentMap.get(id): null;
    }


    @Override
    public Student modify(Student student) {
        Student dbStudent = getStudent(student.getId());
        if (Objects.isNull(dbStudent)) {
            throw new UserNotFoundException();
        }
        dbStudent.setName(student.getName());
        dbStudent.setEmail(student.getEmail());
        dbStudent.setScore(student.getScore());
        dbStudent.setComment(student.getComment());

        return dbStudent;
    }
}
