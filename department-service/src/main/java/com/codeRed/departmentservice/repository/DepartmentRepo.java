package com.codeRed.departmentservice.repository;

import com.codeRed.departmentservice.model.Department;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepo {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long Id) {
        return departments.stream().filter(
                department ->
                        department.getId().equals(Id)
        ).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}

