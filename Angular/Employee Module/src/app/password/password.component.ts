import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {
  empId : string;
  oldPassword : string;
  newPassword : string;
  employee : Employee;
  constructor(private service : EmployeeService, private router : Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('status')==='false'){
      this.router.navigate(['login']);
    }
    this.empId = sessionStorage.getItem('empId');
  }
  changePassword(){
    
    let emp = this.service.changePassword(this.empId, this.oldPassword, this.newPassword).subscribe(data => {
      this.employee = data;
      console.log(emp);
      if(this.employee != null){
        alert("Password changed successfully!");
        this.router.navigate(['search']);
      }else{
      //alert("Password could not be changed!");
        this.router.navigate(['password']);
      }
      error => alert("Password could not be changed!");
    });
    
  }
}
