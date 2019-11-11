import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  designations : String[] = ['Analyst','Senior Analyst','Consultant','Associate Consultant','Senior Consultant','Manager','Senior Manager'];
  domains : String[] = ['Java', 'DevOps', 'AWS', 'Angular', 'SAP', 'Python'];
  employee : Employee;
  pan : string;
  domain : string;
  designation : string;
  salary : number;
  employees : Employee[];
  //employees : Observable<Employee[]>;
  emp : Observable<Employee>;
  constructor(private employeeService: EmployeeService, private router: Router) {
    this.employee = new Employee();
   }

  ngOnInit() {
    this.emp = this.employeeService.searchId(sessionStorage.getItem('empId'));
  }
  updateEmployee(){
    this.employee.empId = sessionStorage.getItem('empId');
    console.log(this.employee);
    console.log(this.employee.empId);
    this.employeeService.updateEmployee(this.pan, this.designation, this.domain, this.salary).subscribe(data => {
      this.employee = data;
      //this.employees = this.employee;
      if(this.employee.empId == null){
        this.router.navigate(['update']);
        alert("Changes not updated!")
      }
      else{
          this.router.navigate(['search']);
          alert("Changes updated!");
      }
  });;
  }

  displayDetails(){
    this.employeeService.searchId(sessionStorage.getItem('empId')).subscribe(data => this.employee = data);
  }
}
