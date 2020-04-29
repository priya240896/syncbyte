package com.syncbyte.registration.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syncbyte.registration.dao.AttendenceRepository;
import com.syncbyte.registration.dao.EmployeeRepository;
import com.syncbyte.registration.entity.CheckIn;
import com.syncbyte.registration.entity.Employee;
import com.syncbyte.registration.entity.EmployeeAttendence;
import com.syncbyte.registration.service.EmployeeService;
import com.syncbyte.registration.util.ExcelGenerator;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	int countcheckin=0;
 
    @Autowired
    private EmployeeService userService;
    
    @Autowired
    private AttendenceRepository attrep;
    
    @Autowired
    private EmployeeRepository userRepo;
 
    
 
    @PostMapping("/employee")
    void addEmployee(@RequestBody Employee employeeDeatils) {
    	userService.saveUser(employeeDeatils);
    }
    
    
    @PostMapping("/employeeCheckIn")
    public Boolean checkinEmployee(@RequestBody CheckIn checkinDetail)
    {   
    	System.out.println(checkinDetail);
    	try {
    		
    		Long employeecode=checkinDetail.getEmployeeCode();
    	    String password=checkinDetail.getPassword();
    	    Employee employee=userService.findByEmpolyeecodeAndPassword(employeecode, password);
    	
		if(employee==null){
			throw new Exception("user not found");
			}
		System.out.println(employee);
		System.out.println("user with credentials found");
		//return new ResponseEntity<String>(employee.getName(), HttpStatus.OK);
        EmployeeAttendence a = new EmployeeAttendence();
        countcheckin=countcheckin+1;
        a.setEmployeeCode(employeecode);
    	a.setAttendence(countcheckin);
    	System.out.println(countcheckin);
    	attrep.save(a);
    	return true;
            } 
	catch (Exception e) {
    	System.out.println("invalid credentials"+e);
    		//return new ResponseEntity<String>("{ \"message\": \""+e.getMessage() + "\"}",HttpStatus.CONFLICT);
    		// TODO: handle exception
    	return false;
    	
    	}
    }
    	@PutMapping("/employee/{employeecode}")
    	public Boolean updateEmployee(@RequestBody Employee employeeDeatils, @PathVariable(value = "employeecode") Long employeecode)
    	{
    		
    		userService.updateEmployee(employeecode,employeeDeatils);
    		return true;
    	}
    	
    	@DeleteMapping("/employees/{employeecode}")
    	public Boolean deleteEmployee(@PathVariable ("employeecode") Long employeecode)
    	{
    		userService.deleteEmployee(employeecode);
    		return true;
    	}
    	
    	@GetMapping(value = "/download/employees.xlsx")
        public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
            List<Employee> employees = (List<Employee>) userRepo.findAll();
            List<EmployeeAttendence> employeesAttendance = (List<EmployeeAttendence>) attrep.findAll();

        List<Employee> employees2 = employees;
        // return IOUtils.toByteArray(in);
        int i =0;
        for(Employee employee: employees) {
        	
        	for(EmployeeAttendence employeeAttendence: employeesAttendance) {
        		if(employee.getEmployeecode() == employeeAttendence.getEmployeeCode()) {
        			Employee employee2 = employee;
        			employee2.setAttendenceCount(employeeAttendence.getAttendence());
        			employees2.set(i, employee2);
        		}
        	}
        	i++;
        }
        ByteArrayInputStream in = ExcelGenerator.employeeToExcel(employees2);
        HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=employees.xlsx");
        System.out.println("here");
         return ResponseEntity
                      .ok()
                      .headers(headers)
                      .body(new InputStreamResource(in));
        }
    	


}
    	
    
