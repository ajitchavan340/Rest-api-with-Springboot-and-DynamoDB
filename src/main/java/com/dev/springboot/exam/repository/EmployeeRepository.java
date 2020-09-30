package com.dev.springboot.exam.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dev.springboot.exam.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String employeeid){
        return dynamoDBMapper.load(Employee.class,employeeid);
    }

    public String delete(String employeeid){
        Employee emp = dynamoDBMapper.load(Employee.class, employeeid);
        dynamoDBMapper.delete(emp);
        return "Employee deleted !";
    }

    public String update(String employeeid , Employee employee){
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
        .withExpectedEntry("employeeid",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(employeeid)
                )));
        return employeeid;
    }


}
