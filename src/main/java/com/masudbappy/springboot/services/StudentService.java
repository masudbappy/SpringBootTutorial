package com.masudbappy.springboot.services;

import com.masudbappy.springboot.entities.Student;
import com.masudbappy.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student){
        if (student == null) throw new NullPointerException("Student can not be null");
        return studentRepository.save(student);
    }

}
