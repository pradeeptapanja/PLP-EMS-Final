import { Component, OnInit } from '@angular/core';
import { Admin } from '../adminmodel/admin';
import { Router } from '@angular/router';
import { ExpenseService } from '../expense/expense.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  adminPassword: string;
  admin: Admin;
  admin1: Admin;

  constructor(private appComponent: AppComponent, private service: ExpenseService, private router: Router) {
    this.admin = new Admin();
    this.admin1 = new Admin();
  }

  ngOnInit() {  }

  loginAdmin() {
    this.service.loginAdmin(this.admin.adminId, this.admin.adminPassword).subscribe(data => {
      this.admin1 = data;
      sessionStorage.setItem('adminId', String(this.admin1.adminId));
      sessionStorage.setItem('adminName', String(this.admin1.adminName));
      sessionStorage.setItem('adminPassword', String(this.admin1.adminPassword));
      sessionStorage.setItem('status', 'true');
      this.service.saveAdmin(this.admin1);
      if (this.admin1.adminId == null)
        this.router.navigate(['login']);
      else {
        this.router.navigate(['display']);
        alert(this.admin1.adminName+", Welcome onboard");
        this.appComponent.tabFlag();
      }
      error => alert("Admin not logged in!");
    });
  }

}
