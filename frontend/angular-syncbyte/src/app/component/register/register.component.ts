import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/Services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

   newEmployee:Employee;
  constructor(private employeeService:EmployeeService, private route: Router ) {
    this.newEmployee=new Employee();
    this.newEmployee.fingerprint=false;
    
   }

  ngOnInit(): void {
    
  }

  setFingerPrint() {
    this.newEmployee.fingerprint=true;
  }
  onSubmit() {
    this.employeeService.save(this.newEmployee).subscribe(res=>{
      console.log(res)
    });
    console.log(this.newEmployee);
    let rout= `/home/${true}`
    this.route.navigate([rout]);
  }
  clickEvent()
  {
    return true;
  }
}
