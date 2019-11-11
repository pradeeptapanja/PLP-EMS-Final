import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../model/ExpenseClaim';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modify-claim',
  templateUrl: './modify-claim.component.html',
  styleUrls: ['./modify-claim.component.css']
})
export class ModifyClaimComponent implements OnInit {
  claim:ExpenseClaimModel;
  result:ExpenseClaimModel;
  employeeDetails:Employee;
  empExist:boolean = false;
  employeeId:String;
  projectIds:number[];
  expenseIds:number[];
  clientIds:number[] = [301,302,303];
  financeUserIds:number[];



  constructor(private service:EmployeeService,private route:Router) {
    this.employeeDetails = new Employee();
    this.claim=new ExpenseClaimModel();
    this.result=new ExpenseClaimModel();
    this.service.getProjectCode().subscribe(p=> this.projectIds =p);
    this.service.getExpenseCode().subscribe(p=> this.expenseIds=p);
    this.service.getFinanceCode().subscribe(p=> this.financeUserIds=p);
   }

  ngOnInit() {
  }

  updateClaim(){
    this.claim.status="Applied";
   // this.claim.employeeId=this.employeeId;
    this.service.updateExpenseClaim(this.claim).subscribe(exp=> {
      this.result=exp;
      this.claim=new ExpenseClaimModel;
      this.result=new ExpenseClaimModel;
      this.route.navigate(['search']);
    });
    

  }

  showEmp(){
    this.employeeId=this.claim.employeeId;
    this.service.getEmployee(this.claim.employeeId).subscribe(emp=>this.employeeDetails=emp);
  }


}
