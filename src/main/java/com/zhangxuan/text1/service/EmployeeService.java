package com.zhangxuan.text1.service;

import com.zhangxuan.text1.entities.Employee;


import java.util.List;

/**
 * @author Administrator
 */
public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    void insertEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
