package com.jdbbank.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdbbank.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByDeptId(Integer deptId);
    List<Employee> findByOrgId(Integer orgId);
    
}
