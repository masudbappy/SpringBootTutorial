package com.masudbappy.springboot.services;

import com.masudbappy.springboot.entities.Department;
import com.masudbappy.springboot.entities.Student;
import com.masudbappy.springboot.repositories.DepartmentRepository;
import com.masudbappy.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public Student save(Student student){
        if (student == null) throw new NullPointerException("Student can not be null");
        if (student.getDepartment() != null){
            Department department = this.departmentRepository.save(student.getDepartment());
            student.setDepartment(department);
        }
        return studentRepository.save(student);
    }

}
