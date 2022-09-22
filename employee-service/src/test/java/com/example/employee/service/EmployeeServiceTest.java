package com.example.employee.service;

import com.example.employee.bean.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Resource
    private EmployeeService employeeService;

    @Test
    void getEmployeeById() {

        Employee emp = employeeService.getEmployeeById(1L);
        System.out.println(emp);
    }
}