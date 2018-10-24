package com.masudbappy.springboot.repositories;

import com.masudbappy.springboot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select u from Student u where u.name=?1")
    Student findByStudentname(String name);

//    @Query("select u from Student u where u.id = ?1")
//    Student findByID(Long studentID);

    @Query("select u from Student u where u.id = ?1")
    Student findByID(Long studentID);

}
