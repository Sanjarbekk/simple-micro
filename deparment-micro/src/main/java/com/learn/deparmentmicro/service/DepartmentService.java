package com.learn.deparmentmicro.service;

import com.learn.deparmentmicro.entity.Department;
import com.learn.deparmentmicro.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    public Department save(Department department) {
        Department department1 = departmentRepository.save(department);
        System.out.println(department1);
        return  department1;
    }

    public Department getById(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }
}