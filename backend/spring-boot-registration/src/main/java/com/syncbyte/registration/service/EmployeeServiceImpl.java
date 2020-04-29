package com.syncbyte.registration.service;

import org.springframework.stereotype.Service;

import com.syncbyte.registration.dao.EmployeeRepository;
import com.syncbyte.registration.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
private final EmployeeRepository userRepo;
	
	
	public EmployeeServiceImpl(EmployeeRepository userRepo) {
		super();
		this.userRepo=userRepo;
	}

	@Override
	public void saveUser(Employee user)  {
		userRepo.save(user);
	}

	@Override
	public Employee findByEmpolyeecodeAndPassword(Long employeecode,String password) 
	{
		
		Employee employee = userRepo.findByEmployeecodeAndPassword(employeecode, password);
		return employee;
	
	}

	@Override
	public void updateEmployee(Long employeecode,Employee employeeDeatils)
	{
		Employee employee = userRepo.findByEmployeecode(employeecode);
		employee.setEmployeecode(employeeDeatils.getEmployeecode());
		employee.setName(employeeDeatils.getName());
		employee.setDob(employeeDeatils.getDob());
		employee.setPassword(employeeDeatils.getPassword());
	   final Employee updatedEmployee = userRepo.save(employee);
		
	}
	
	@Override
	public void deleteEmployee(Long employeecode)
	{
		Employee employee = userRepo.findByEmployeecode(employeecode);
		userRepo.delete(employee);
	}
}
	


