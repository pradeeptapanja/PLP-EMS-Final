import { Component } from '@angular/core';
import { ExpenseService } from './expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'expensemodule';

  flag: boolean;
  name: string;

  constructor(private service: ExpenseService, private router: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('status') == 'true') {
      this.flag = true;
    }
    else
      this.flag = false;
  }
  logout() {
    sessionStorage.setItem('status', 'false');
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
  tabFlag() {
    if (sessionStorage.getItem('status') == 'true')
      this.flag = true;
    else
      this.flag = false;
  }
}