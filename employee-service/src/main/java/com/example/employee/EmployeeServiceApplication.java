package com.example.employee;

import com.example.employee.bean.Employee;
import com.example.employee.service.EmployeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
@MapperScan(basePackages = "com.example.employee.dao")
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private EmployeeService service;

    @GetMapping("/employee")
    public Employee getEmployee(@RequestParam("id") Long id) {
        return service.getEmployeeById(id);
    }
}
