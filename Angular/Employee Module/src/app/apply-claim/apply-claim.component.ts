import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { ExpenseClaimModel } from '../model/ExpenseClaim';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-apply-claim',
  templateUrl: './apply-claim.component.html',
  styleUrls: ['./apply-claim.component.css']
})
export class ApplyClaimComponent implements OnInit {
  claim:ExpenseClaimModel;
  result:ExpenseClaimModel;
  employeeDetails:Employee;
  empExist:boolean = false;
  employeeId:string;
  projectIds:number[];
  expenseIds:number[];
  clientIds:number[] = [301,302,303];
  financeUserIds:number[];
  check:String=null;
  startDate:Date;
  endDate:Date;



  constructor(private service:EmployeeService,private route:Router) {
    this.employeeDetails = new Employee();
    this.claim=new ExpenseClaimModel();
    //this.result=new ExpenseClaimModel();
    this.service.getProjectCode().subscribe(p=> this.projectIds =p);
    this.service.getExpenseCode().subscribe(p=> this.expenseIds=p);
    this.service.getFinanceCode().subscribe(p=> this.financeUserIds=p);
   }

  ngOnInit() {
  }

  addClaim(){
    this.claim.status="Applied";
    //this.claim.employeeId=this.employeeId;
    if(this.employeeDetails.empId==null){
      alert ("No Such Employee Found");
    }
    else{
    this.service.addExpenseClaim(this.claim).subscribe(exp=> {
      this.result=exp;
      alert("Claim added successfully");
      this.route.navigate(['search']);
    });
   
    this.claim=new ExpenseClaimModel;
      this.result=new ExpenseClaimModel;
    }
  }

  showEmp(){
    this.employeeId=this.claim.employeeId;
    this.service.getEmployee(this.claim.employeeId).subscribe(emp=>{ 
      this.employeeDetails=emp;
      // if(this.employeeDetails==null){
      //   alert("No Employee With Such Id Found");
      // }
      // else{
        this.empExist=true;
      }
   // }
      );
  }

}
