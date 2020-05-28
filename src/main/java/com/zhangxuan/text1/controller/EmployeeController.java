package com.zhangxuan.text1.controller;

import com.zhangxuan.text1.dao.DepartmentDao;
import com.zhangxuan.text1.entities.Department;
import com.zhangxuan.text1.entities.Employee;
import com.zhangxuan.text1.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
public class EmployeeController {

    Logger logger=LoggerFactory.getLogger(getClass());
    EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    DepartmentDao departmentDao;
    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @GetMapping("/emps")
    public String list(Model model){

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employee", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String tooAddPage(Model model){
        List<Department> depart = departmentDao.findAll();
        model.addAttribute("departs1",depart);
        return "emp/add";

    }
    @PostMapping("/emp")
    public String insertEmp(Employee employee){
        employeeService.insertEmp(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String tooUpdatePage(@PathVariable("id") Integer id, Model model){

        List<Department> depart = departmentDao.findAll();
        model.addAttribute("departs1",depart);

        Employee emp1 = employeeService.findById(id);
        model.addAttribute("emp", emp1);
        return "emp/add";
    }

    @PutMapping("/emp")
        public String updateEmp(Employee employee){
            employeeService.updateEmp(employee);
            return "redirect:/emps";
    }

    @RequestMapping("/empDelete")
    public String deleteEmp(@RequestParam("id") Integer id){
        logger.info("删除方法日志");

        employeeService.deleteEmp(id);
        return "redirect:/emps";
    }
}
