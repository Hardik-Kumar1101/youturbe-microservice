package com.codeRed.departmentservice.controller;


import com.codeRed.departmentservice.client.EmployeeClient;
import com.codeRed.departmentservice.model.Department;
import com.codeRed.departmentservice.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        return departmentRepo.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentRepo.findById(id);
    }

    @GetMapping("/with-employee")
    public List<Department> findAllWithEmployees() {
        List<Department> departments = departmentRepo.findAll();
        System.out.println(" with called .");
        departments.forEach(department -> {
            System.out.println("department Id: " + department.getId());
            department.setEmployes(employeeClient.findByDepartment(department.getId()));
        });

        return departments;
    }
}
