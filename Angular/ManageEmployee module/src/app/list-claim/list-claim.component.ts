import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../model/ExpenseClaim';
import { ManageService } from '../manage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-claim',
  templateUrl: './list-claim.component.html',
  styleUrls: ['./list-claim.component.css']
})
export class ListClaimComponent implements OnInit {
  expenseClaims:ExpenseClaimModel;

  constructor(private service:ManageService,private route:Router) {
    this.expenseClaims=new ExpenseClaimModel;
  }

  ngOnInit() {
   // this.expenseClaims=new ExpenseClaimModel;
  }
  listClaim() {
    this.service.listExpenseClaims(this.expenseClaims.claimId).subscribe(p =>{

    this.expenseClaims =p;
    if(this.expenseClaims == null){
      alert("Claim not found");
      this.route.navigate(['list']);
    }else{
      alert("Claim  found");
    }
  });
  }

}
