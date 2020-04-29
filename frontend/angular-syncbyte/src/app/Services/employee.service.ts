import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Employee, CheckIn } from '../common/employee';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private employeeUrl:string;
  private employeeCheckInUrl:string;
  private employeesUrl:string;
  private empListUrl:string;

  constructor(private http:HttpClient) { 
    this.employeeUrl='http://localhost:8080/employee';
    this.employeesUrl='http://localhost:8080/employees';
    this.employeeCheckInUrl='http://localhost:8080/employeeCheckIn';
    this.empListUrl="http://localhost:8080/download/employees.xlsx"

  }
  public save(employee:Employee)
  {
    return this.http.post<Employee>(this.employeeUrl,employee);
  }
  public checkin(employee:CheckIn):Observable<any>{
    return this.http.post(this.employeeCheckInUrl,employee)

  }
  public update(employeecode:number,employee:Employee):Observable<any>{
    let uri = `${this.employeeUrl}/${employeecode}`;
    return this.http.put(uri,employee);
  }
  public delete(employeecode:number):Observable<any>{
    let headers = new HttpHeaders();
    headers.append('Content-Type','application/json');
    let uri = `${this.employeesUrl}/${employeecode}`;
    return this.http.delete(uri,{responseType: 'text',headers : headers});
  }
  public get(employee:Employee):Observable<any>{
    return this.http.get(this.empListUrl,
      {responseType: "arraybuffer"});
  }
  

  
  
}
