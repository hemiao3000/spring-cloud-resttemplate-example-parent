package com.example.employee.service;

import com.example.employee.bean.Department;
import com.example.employee.bean.Employee;
import com.example.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private RestTemplate restTemplate;

    public Employee getEmployeeById(Long id) {
        Employee employee = employeeDao.selectById(id);
        Department department = restTemplate.getForObject("http://department-service/department?id=" + id, Department.class);
        employee.setDepartment(department);
        return employee;
    }
}
