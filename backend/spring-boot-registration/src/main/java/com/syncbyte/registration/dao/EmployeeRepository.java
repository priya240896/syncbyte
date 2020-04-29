package com.syncbyte.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syncbyte.registration.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByEmployeecodeAndPassword(Long employeecode,String password);
    Employee findByEmployeecode(Long employeecode);
}
