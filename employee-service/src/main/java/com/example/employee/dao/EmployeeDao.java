package com.example.employee.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.employee.bean.Department;
import com.example.employee.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

public interface EmployeeDao extends BaseMapper<Employee> {
//    Employee getEmployeeById(Long id);
}
