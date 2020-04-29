package com.syncbyte.registration.service;

import com.syncbyte.registration.entity.Employee;

public interface EmployeeService {
	void saveUser(Employee employeeDetail);
	
	Employee findByEmpolyeecodeAndPassword(Long employeecode,String password);
	
	void updateEmployee(Long employeecode,Employee employeeDeatils);
	
	void deleteEmployee(Long employeecode);
	

}
