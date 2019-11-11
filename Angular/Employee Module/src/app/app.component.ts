import { Component } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Router } from '@angular/router';
import { Employee } from './model/employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EmpModule';
  flag : boolean;
  //employee : Employee;
  constructor(private service : EmployeeService, private router : Router) { }
  ngOnInIt(){
    if(sessionStorage.getItem('status')=='true')
      this.flag = true;
    else
      this.flag = false;
  }
  logout(){
    sessionStorage.setItem('status','false');
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
  tabFlag(){
    console.log(sessionStorage);
    if(sessionStorage.getItem('status')=='true'){
      this.flag = true;
      //this.employee.name = sessionStorage.getItem('empId');
    }
      else
    this.flag = false;
  }
}
