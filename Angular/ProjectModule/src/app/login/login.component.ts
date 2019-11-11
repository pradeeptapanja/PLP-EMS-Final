import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/admin';
import { Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
adminId: string;
adminPassword: string;
admin : Admin;
  constructor(private appComponent : AppComponent, private service : ProjectService, private router : Router) { }

  ngOnInit() {
    this.admin= new Admin();
  }
  loginAdmin(){
    this.service.loginAdmin(this.adminId, this.adminPassword).subscribe(data => {
      this.admin = data;
      if(this.admin == null){
        alert("Wrong credentials");
        this.router.navigate(['login']);
      }
      else{
        sessionStorage.setItem('adminId', String(this.admin.adminId));
      sessionStorage.setItem('adminName', String(this.admin.adminName));
      sessionStorage.setItem('adminPassword',String(this.admin.adminPassword));
      sessionStorage.setItem('status','true');
      this.service.saveAdmin(this.admin);
      this.router.navigate(['display']);
      alert("Login Successful");
      this.appComponent.tabFlag();
      }
      error => alert("Admin not logged in!");
    });
  }

}
