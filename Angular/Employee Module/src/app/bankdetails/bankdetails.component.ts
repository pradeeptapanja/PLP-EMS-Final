import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-bankdetails',
  templateUrl: './bankdetails.component.html',
  styleUrls: ['./bankdetails.component.css']
})
export class BankdetailsComponent implements OnInit {
  bankName : string;
  accountNo : string;
  empId : string;
  salary : string;
  employee : Employee;
  banks : String[] = ['Axis Bank', 'Citi Bank','HDFC Bank','ICICI Bank', 'Standard Chartered Bank'];
  constructor(private employeeService : EmployeeService, private router : Router) { }

  ngOnInit() {
    
  }
  addBankDetails(){
   
    console.log(this.empId);
    this.employeeService.addBank( this.bankName, this.accountNo, this.salary).subscribe(data => {
      this.employee = data;
      this.employeeService.saveEmployee(this.employee);
      if(this.employee.empId == null)
        this.router.navigate(['bank']);
      else{
      this.router.navigate(['search']);
      alert("Bank details changed!");
      }
      error => alert("Employee not logged in!");
    });
    
    
    
    

    
    //   if(emp != null){
    //   alert("Bank details updated successfully!");
    //   this.router.navigate(['search']);
    // }else{
    //   alert("Bank Details could not be added!");
    //   this.router.navigate(['password']);
    // }
  }
}
