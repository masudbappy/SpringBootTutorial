package com.masudbappy.springboot.controllers;

import com.google.gson.JsonObject;
import com.masudbappy.springboot.entities.Department;
import com.masudbappy.springboot.exceptions.notfound.NotFoundException;
import com.masudbappy.springboot.repositories.DepartmentRepository;
import com.masudbappy.springboot.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    private DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) throws NotFoundException {

        Department departmentObj = departmentService.createDepartment(department);

        /* you can call location uri for new resource*/
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(departmentObj.getId()).toUri();


        //return ResponseEntity.created(location).build();
        return ResponseEntity.ok(departmentObj);
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateDepartment(@PathVariable Long id,
                                                   @RequestBody Department department)
            throws NotFoundException {

        Optional<Department> departmentObj = this.departmentService.findADepartment(id);

        if (!departmentObj.isPresent())
            return ResponseEntity.notFound().build();

        department.setId(id);
        departmentService.createDepartment(department);

        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable Long id) throws NotFoundException {


        Optional<Department> department = this.departmentService.findADepartment(id);
        if (department == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // throw new NotFoundException("" + id + " is not in DB");

        Map<String, String> stringStringMap = new HashMap<>();
        if (departmentService.deleteADepartment(id)) {
            stringStringMap.put("status", "success");
            stringStringMap.put("message", "successfully deleted");
            stringStringMap.put("code", "200");
            return ResponseEntity.status(HttpStatus.OK).body(stringStringMap);

        } else {
            stringStringMap.put("status", "failed");
            stringStringMap.put("message", "not  deleted");
            stringStringMap.put("code", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stringStringMap);

        }




    }
}
