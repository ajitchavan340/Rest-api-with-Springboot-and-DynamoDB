package com.dev.springboot.exam.controller;

import com.dev.springboot.exam.entity.Employee;
import com.dev.springboot.exam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Employeecontroller {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String id){
        return employeeRepository.getEmployeeById(id);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteemployee(@PathVariable("id") String id){
        return employeeRepository.delete(id);
    }
    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String id , @RequestBody Employee employee){
        return employeeRepository.update(id,employee);
    }
}
