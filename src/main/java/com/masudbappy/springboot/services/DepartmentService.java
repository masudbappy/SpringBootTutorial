package com.masudbappy.springboot.services;

import com.masudbappy.springboot.entities.Department;
import com.masudbappy.springboot.exceptions.notfound.NotFoundException;
import com.masudbappy.springboot.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    DepartmentRepository repository;

    @Autowired
    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }


    public Department createDepartment(Department department) throws NotFoundException {

        if (department != null) {
            repository.save(department);
            return repository.save(department);
        } else {
            throw new NotFoundException("");
        }

    }


    public Department updateDepartment(Department department) throws NotFoundException {

        if (department != null) {
            repository.save(department);
            return repository.save(department);
        } else {
            throw new NotFoundException("No Department with such ID");
        }

    }


    public Optional<Department> findADepartment(Long id) {

        return repository.findById(id);
    }


    public boolean deleteADepartment(Long id) {

        Optional<Department> department = findADepartment(id);
        if (department.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
