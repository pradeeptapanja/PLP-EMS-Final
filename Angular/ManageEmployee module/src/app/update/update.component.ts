import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';
import { ManageService } from '../manage.service';
import { Router } from '@angular/router';

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
  employeeId : string;
  found : boolean;
  //employees : Observable<Employee[]>;
  emp : Observable<Employee>;
  constructor(private employeeService: ManageService, private router: Router) {
    this.employee = new Employee();
   }

  ngOnInit() {
    this.emp = this.employeeService.searchId(sessionStorage.getItem('empId'));
  }
  updateEmployee(){
    sessionStorage.setItem('empId',this.employee.empId);
    console.log(this.employee);
    console.log(sessionStorage);
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
    this.employeeService.searchId(this.employeeId).subscribe(data => {
      this.employee = data;
      if(this.employee == null)
        this.found = true;
      else{
        console.log(this.employee);
        this.found = false;
      }
    });
    console.log(this.employeeId);
  }
}
