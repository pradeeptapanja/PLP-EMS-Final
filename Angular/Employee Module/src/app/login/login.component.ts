import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { RouterModule, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { AppComponent } from '../app.component';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  empId : string;
  password : string;
  employee : Employee;
  

  constructor(private appComponent : AppComponent,private employeeService : EmployeeService, private router : Router) { }

  ngOnInit() {

    this.employee = new Employee();
  }
  loginEmployee(){
    console.log("In login");
    this.employeeService.loginEmployee(this.empId, this.password).subscribe(data => {
      this.employee = data;
      
      if(this.employee == null){
        alert("Employee does not exist. Try again!")
        this.router.navigate(['login']);
      }
      else{
        sessionStorage.setItem('empId', String(this.employee.empId));
      sessionStorage.setItem('password',String(this.employee.password));
      //sessionStorage.setItem('name', String(this.employee.name));
      sessionStorage.setItem('status','true');
      this.employeeService.saveEmployee(this.employee);
        this.appComponent.tabFlag();
        this.router.navigate(['search']);
        alert("Login Successful");
      }
      error => alert("Employee not logged in!");
    });
  }
      //if(emp!=null){
       // console.log("in logincheck if");
        //sessionStorage.setItem('empId', String(this.employee.empId));
        //sessionStorage.setItem('password',String(this.employee.password));
        //sessionStorage.setItem('status','true');
        //alert("Employee logged in successfully!");
        //this.router.navigate(['search']);
     // }else{
        //console.log("in logincheck else");
       // alert("Employee not logged in !");
        //this.router.navigate(['login']);
     // }
  
  

}
