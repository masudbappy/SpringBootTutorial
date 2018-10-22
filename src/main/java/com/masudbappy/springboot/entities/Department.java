package com.masudbappy.springboot.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department extends BaseEntity {


    private String name;
    @OneToMany(mappedBy = "department")
    List<Student> students;

    public Department() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
