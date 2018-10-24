package com.masudbappy.springboot.repositories;

import com.masudbappy.springboot.entities.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


//    @Query("select u from Student u where u.id = ?1")
//    Student findByID(Long studentID);

    @Query("select u from Student u where u.id = ?1")
    Student findByID(Long studentID);

}
