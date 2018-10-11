package com.masudbappy.springboot.repositories;

import com.masudbappy.springboot.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
