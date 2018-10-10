package com.masudbappy.springboot.controllers;

import com.masudbappy.springboot.entities.Student;
import com.masudbappy.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

   private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/createStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody Student student){
        student = this.studentService.save(student);
        return ResponseEntity.ok(student);
    }

}
