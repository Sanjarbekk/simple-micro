package com.learn.deparmentmicro.controller;

import com.learn.deparmentmicro.entity.Department;
import com.learn.deparmentmicro.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        log.debug(String.valueOf(department));
        return ResponseEntity.ok().body(departmentService.save(department));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(departmentService.getById(id));
    }
}