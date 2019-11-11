import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private appComponent : AppComponent,private service : ExpenseService, private router : Router) { }

  ngOnInit() {
    this.service.deleteUser();
    this.appComponent.logout();
    this.appComponent.tabFlag();
    this.router.navigate(['login']);
  }

}
