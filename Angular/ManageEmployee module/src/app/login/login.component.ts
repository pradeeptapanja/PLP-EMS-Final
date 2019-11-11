import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { AppComponent } from '../app.component';
import { ManageService } from '../manage.service';
import { Router } from '@angular/router';
import { AdminClass } from '../model/adminClass';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  adminId : string;
  password : string;
  employee : Employee;
  admin : AdminClass;

  constructor(private appComponent : AppComponent,private service : ManageService, private router : Router) { }

  ngOnInit() {

    this.employee = new Employee();
  }
  loginAdmin(){
    this.service.loginAdmin(this.adminId, this.password).subscribe(data => {
      this.admin = data;
      sessionStorage.setItem('adminId', String(this.admin.adminId));
      sessionStorage.setItem('password',String(this.admin.adminPassword));
      //sessionStorage.setItem('name', String(this.employee.name));
      sessionStorage.setItem('status','true');
      this.service.saveAdmin(this.admin);
      if(this.admin.adminId == null)
        this.router.navigate(['login']);
      else{
        this.appComponent.tabFlag();
        this.router.navigate(['list']);
        alert("Login Successful");
      }
      error => alert("Employee not logged in!");
    });
  }

}
