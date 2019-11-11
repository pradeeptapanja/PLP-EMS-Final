import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private appComponent : AppComponent,private financeService : FinanceuserService, private router : Router) { }

  ngOnInit() {
    this.financeService.deleteFinanceUser();
    this.appComponent.logout();
    this.appComponent.tabFlag();
    this.router.navigate(['login']);
  }

}
