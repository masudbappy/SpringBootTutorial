package com.masudbappy.springboot.entities;

import javax.persistence.*;

@Entity
@Table
public class Student extends BaseEntity{

    private String name;
    private String university;
    @ManyToOne
    private Department department;

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
