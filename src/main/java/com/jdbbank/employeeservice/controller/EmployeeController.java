package com.jdbbank.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbbank.employeeservice.model.Employee;
import com.jdbbank.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    Logger logger=LoggerFactory.getLogger(getClass());

    @Autowired
    
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployees(){
        logger.info("done");
        return employeeService.findAllEmployees();
    }


    @GetMapping("/{id}")
    public Employee finEmployee(@PathVariable Long id){
        return employeeService.findEmployeeById(id);

    }

    @PostMapping
    public Employee newEmployee(@RequestBody Employee employee){
        return employeeService.newEmployee(employee);
    }

    @PutMapping
    public Employee updatEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee.getId(),employee);
    }

    @DeleteMapping ("/{id}")
    public void  deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/department/{deptId}")
    public  List<Employee> findByDeptId (@PathVariable Integer deptId){
        logger.info("success");
        return employeeService.findByDeptId(deptId);
    }
    

    
    @GetMapping("/organization/{orgId}")
    public  List<Employee> findByOrgId (@PathVariable Integer orgId){
        logger.info("success");
        return employeeService.findByOrgId(orgId);
    }


    @GetMapping("/test")
    public String test(){
        return "internal-micro test:";

    }
}
