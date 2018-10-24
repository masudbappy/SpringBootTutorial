package com.masudbappy.springboot.services;

import com.masudbappy.springboot.entities.Department;
import com.masudbappy.springboot.entities.Student;
import com.masudbappy.springboot.exceptions.notfound.StudentNotFoundException;
import com.masudbappy.springboot.repositories.DepartmentRepository;
import com.masudbappy.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public Student save(Student student) {
        if (student == null) throw new NullPointerException("Student can not be null");
        if (student.getDepartment() != null) {
            Department department = this.departmentRepository.save(student.getDepartment());
            student.setDepartment(department);
        }
        return studentRepository.save(student);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        if (id == null) throw new IllegalArgumentException("Id can't be null");
        this.studentRepository.deleteById(id);
    }


    public Student getStudent(Long id) throws StudentNotFoundException {

        Student s;
        if (id == 0) throw new IllegalArgumentException("Id can't be null");

        else {
            s = studentRepository.findByID(id);
            if (s == null) {

                throw new StudentNotFoundException("this id is not Found in DB");
            }
        }
        return s;
    }

}
