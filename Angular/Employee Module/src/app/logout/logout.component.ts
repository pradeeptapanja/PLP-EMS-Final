import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  

  constructor(private appComponent : AppComponent, private employeeService : EmployeeService, private router : Router) { }

  ngOnInit() {
    this.employeeService.deleteEmployee();
    this.appComponent.tabFlag();
    this.router.navigate(['login']);
  }

}
