package com.jdbbank.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbbank.employeeservice.model.Employee;
import com.jdbbank.employeeservice.repository.EmployeeRepository;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //find all emp
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();

    }

    
    //find by id
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);

    }
    
    //add new
    public Employee newEmployee(Employee employee){
        return employeeRepository.save(employee);

    }

    //update
    public Employee updateEmployee(Long id, Employee updateEmployee){

        if (employeeRepository.existsById(id)) {
            updateEmployee.setId(id);
            return employeeRepository.save(updateEmployee);
        }else{
            throw new RuntimeException("not found id:" + id);
        }

    }
    
    //delete
    public void deleteEmployee(Long id){

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            
        }else{
            throw new RuntimeException("not found id:" + id);
        }

    }

    
    
    //find depl ID
    public List<Employee> findByDeptId(Integer deptId){
        return employeeRepository.findByDeptId(deptId);

    }

        
    //find by org ID
    public List<Employee> findByOrgId(Integer orgId){
        return employeeRepository.findByOrgId(orgId);

    }


}
