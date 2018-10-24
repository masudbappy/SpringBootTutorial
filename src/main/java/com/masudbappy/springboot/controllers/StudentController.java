package com.masudbappy.springboot.controllers;

import com.masudbappy.springboot.entities.Student;
import com.masudbappy.springboot.exceptions.notfound.StudentNotFoundException;
import com.masudbappy.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

   private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStudent(@RequestBody Student student){
        student = this.studentService.save(student);

        return ResponseEntity.ok(student);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudent(@PathVariable("id") Long id,
                                        @RequestBody Student student){
        if (student == null)
            return ResponseEntity.badRequest().build();
        student.setId(id);
        student = this.studentService.save(student);
        return ResponseEntity.ok(student);
    }


    @GetMapping(value = "/getAll")
    public ResponseEntity getAllStudent(){

        List<Student> list = this.studentService.getStudent();
        System.out.println(list.toString());

        return ResponseEntity.ok(list);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id){

        this.studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity getStudentByName(@PathVariable("name") String name) throws StudentNotFoundException {
        Student student = this.studentService.findByStudentName(name);
        return ResponseEntity.ok(student);
    }

}
