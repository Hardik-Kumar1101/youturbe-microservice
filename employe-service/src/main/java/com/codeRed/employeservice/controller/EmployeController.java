package com.codeRed.employeservice.controller;

import com.codeRed.employeservice.model.Employee;
import com.codeRed.employeservice.repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeController {
    @Autowired
    private EmployeRepo employeRepo;

    //    private static final log = LoggerFactory.getLogger(EmployeController.class);
    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        System.out.println("Employee add: {"+employee.toString()+"}");
        return employeRepo.addDepartment(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeRepo.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId) {
        return employeRepo.findByDepartment(departmentId);
    }
}
