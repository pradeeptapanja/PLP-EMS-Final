import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  expense:Expense;
  b:boolean;
  id:number;
  submitted:boolean;

  constructor(private service: ExpenseService, private route:Router) { }

  ngOnInit() {
    this.expense = new Expense();
  }

  searchExpense() {
    this.service.findExpense(this.expense.expenseCode).subscribe(data => this.expense = data);
    if (this.expense != null)
      this.submitted = true;
    else {
      alert("EXPENSE NOT FOUND");
      this.submitted = false;
    }
  }
  removeExpense() {
    var ans = confirm("Are You Sure You want To delete?");
    if (ans){
      this.service.deleteExpense(this.expense.expenseCode).subscribe(data => this.b = data);
    }
    this.route.navigate(['search']);
  }
}