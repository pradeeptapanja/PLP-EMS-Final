import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
//some random comment
export class AddComponent implements OnInit {

  expense : Expense;
  expense1 : Expense;

  constructor(private service: ExpenseService, private route:Router) {
    this.expense = new Expense();
   }

  ngOnInit() {
  }

  addExpense(){
    this.service.saveExpense(this.expense).subscribe(e => this.expense1 = e);
    this.expense = new Expense();
    alert("Expense added")
    this.route.navigate(['search']);              
  }
}