import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  employees :  Employee[];
  found : boolean;
  domain : String;
  designation : String;
  designations : String[] = ['Analyst','Senior Analyst','Consultant','Associate Consultant','Senior Consultant','Manager','Senior Manager'];
  domains : String[] = ['Java', 'DevOps', 'AWS','Cloud', 'Angular', 'SAP', 'Python'];
  constructor(private service : EmployeeService) { }
  ngOnInit(){
    this.found = false;
  }
  searchEmployeeByDomain(){
    let list =  this.service.searchDomain(this.domain).subscribe(data =>{
      this.employees = data; 
      if(this.employees != null){
        this.found = true;
        alert("Employee  found.")
      } else{
        this.found = false;
        alert("Employee not found.")
      }
      error => alert("Search could not be done!")
    });
   
  }

  searchEmployeeByDesignation(){
    let list = this.service.searchDesignation(this.designation).subscribe(data =>{
      this.employees = data;
      if(this.employees != null){
        this.found = true;
        alert("Employee  found.");
      } else{
        this.found = false;
        alert("Employee not found.")
      }
       error => alert("Search could not be done!")
    });
    
  }

}
