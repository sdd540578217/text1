package com.zhangxuan.text1.service;

import com.zhangxuan.text1.dao.DepartmentDao;
import com.zhangxuan.text1.dao.EmployeeDao;
import com.zhangxuan.text1.entities.Department;
import com.zhangxuan.text1.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    DepartmentDao departmentDao;
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }




    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    public void insertEmp(Employee employee) {
        employee.setDepartment(departmentDao.findById(employee.getDepartment().getId()));
        employee.setD_id(employee.getDepartment().getId());
        employeeDao.insertEmp(employee);

    }

    @Override
    public void updateEmp(Employee employee) {
        employee.setD_id(employee.getDepartment().getId());
        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeDao.deleteEmp(id);
    }


}
