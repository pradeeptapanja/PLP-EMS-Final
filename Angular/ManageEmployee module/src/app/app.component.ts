import { Component } from '@angular/core';
import { ManageService } from './manage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ManageEmployee';
  //title = 'EmpModule';
  flag : boolean;
  //employee : Employee;
  constructor(private service : ManageService, private router : Router) { }
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
