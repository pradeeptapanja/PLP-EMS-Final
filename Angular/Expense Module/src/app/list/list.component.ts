import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  expenses: Expense[];

  constructor(private service: ExpenseService) {
    //this.expenses=new Expense();
   }

  ngOnInit() {
    this.service.listExpenses().subscribe(p => this.expenses = p);
  }
}