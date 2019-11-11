import { Component, OnInit } from '@angular/core';
import { ManageService } from '../manage.service';
import { Employee } from '../model/employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  employees : Employee[];
  records: Array<any>;
  isDesc: boolean = false;
  column: string = 'CategoryName';
  result : string;
  constructor(private service : ManageService, private router : Router) { }

  ngOnInit() {
    this.service.listEmployee().subscribe(p=>this.employees = p);
  }

  sort(property) {
    this.isDesc = !this.isDesc; //change the direction    
    this.column = property;
    let direction = this.isDesc ? 1 : -1;

    this.employees.sort(function (a, b) {
      if (a[property] < b[property]) {
        return -1 * direction;
      }
      else if (a[property] > b[property]) {
        return 1 * direction;
      }
      else {
        return 0;
      }
    });
  }
  delete(i : Employee){
    //console.log(i);
    //this.employee = this.employees[i];
    //console.log(i.empId);
    //let empId = i.empId;
    //console.log(empId);
    alert("Are you sure you want to delete the data?");
    this.service.deleteId(i.empId).subscribe(data => 
      this.result = data);
    this.router.navigate(['update']);
  }

}