import { Component, OnInit } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { ExpenseService } from '../expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit {

  expense: Expense;
  expense1: String = "";
  
  constructor(private service: ExpenseService, private route:Router) {
    this.expense = new Expense();
   }

  ngOnInit() {}

  updateExpense(){
    this.service.modifyExpense(this.expense).subscribe(e => this.expense1 = e);
    this.expense = new Expense();
    if(this.expense1 == "Successfully modified"){
        alert("Expense modified");}
    this.route.navigate(['search']);  
  }
}