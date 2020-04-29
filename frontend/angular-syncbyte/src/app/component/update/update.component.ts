import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/Services/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  employeecode:number;
  updateEmployee: Employee;
  constructor(private employeeService:EmployeeService ,private rout:ActivatedRoute) {
    this.updateEmployee=new Employee();
    this.updateEmployee.fingerprint=false;
   }

  ngOnInit(): void {
    this.rout.params.subscribe(params =>{
      this.employeecode = params['employeecode'];
    });
    console.log(this.employeecode);
  }
  setFingerPrint() {
    this.updateEmployee.fingerprint=true;
  }
  onUpdate() {
    this.employeeService.update(this.employeecode,this.updateEmployee).subscribe(res=>{
      console.log(res)
    });
    console.log(this.updateEmployee);
    
  }
  clickEvent()
  {
    return true;
  }
  
}


