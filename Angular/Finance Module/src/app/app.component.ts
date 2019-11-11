import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FinanceuserService } from './financeuser/financeuser.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'finance-module-app';
  flag : boolean;
  name : string;
  constructor(private service : FinanceuserService, private router : Router) { }
  ngOnInIt(){
    if(sessionStorage.getItem('status')=='true'){
      this.flag = true;
      //this.name = sessionStorage.getItem('financeUserName');
    }
    else{
      this.flag = false;
      //this.name = "User";
    }
  }
  logout(){
    sessionStorage.setItem('status','false');
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
  tabFlag(){
    if(sessionStorage.getItem('status')=='true')
    this.flag = true;
  else
    this.flag = false;
  }
}
