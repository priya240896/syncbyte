import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/Services/employee.service';
import { Employee } from 'src/app/common/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { execFile } from 'child_process';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit {
  employeecode:number;
  employee:Employee;
  

  constructor(private employeeService:EmployeeService, private rout:ActivatedRoute,private route:Router) {
    }

  ngOnInit(): void {
    this.rout.params.subscribe(params =>{
      this.employeecode = params['value'];
    });
    
  }
  onUpdate()
  {
    let uri=`/update/${this.employeecode}`
    this.route.navigate([uri]);
  }
  onDelete()
  {
    this.employeeService.delete(this.employeecode).subscribe(res =>{
      console.log(res);
    }
      )

  }
  onGetList()
  {
    this.employeeService.get(this.employee).subscribe(
      
        response => this.downLoadFile(response, "application/ms-excel")
      
    )
  }
  downLoadFile(data: any, type: string) {
    let blob = new Blob([data], { type: "application/ms-excel"});
    let url = window.URL.createObjectURL(blob);
    var anchor = document.createElement("a");
    anchor.download = "Employee.xlsx";
    anchor.href = url
    anchor.click();

}
}