import { Component, OnInit } from '@angular/core';
import { CheckIn } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/Services/employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.css']
})
export class CheckinComponent implements OnInit {
employee: CheckIn;
  constructor(private employeeService:EmployeeService, private route: Router) { 
    this.employee=new CheckIn();
  }

  ngOnInit(): void {
  }
  OnCheckIn()
  {
    this.employeeService.checkin(this.employee).subscribe((res) =>{
      console.log(res)
      if(res==true ){
        console.log("route to inside") 
        let uri=`/modify/${this.employee.employeeCode}`
        this.route.navigate([uri]);
        
        
      }
      else{
        console.log("Invalid credentials")
      }
    },
    (error:HttpErrorResponse)=>{
      console.log("error")
    });
  
  }

}
