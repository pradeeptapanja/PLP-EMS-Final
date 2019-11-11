import { Component, OnInit } from '@angular/core';
import { ExpenseClaimModel } from '../model/ExpenseClaim';
import { ManageService } from '../manage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-claim',
  templateUrl: './delete-claim.component.html',
  styleUrls: ['./delete-claim.component.css']
})
export class DeleteClaimComponent implements OnInit {
  claimId:number;
  deleteStatus:boolean;
  expenseClaims:ExpenseClaimModel;
  constructor(private service:ManageService,private route:Router) {
    //this.claim=new ExpenseClaimModel();
    this.expenseClaims=new ExpenseClaimModel();
   }

  ngOnInit() {
  }
  deleteClaim(){
    this.service.deleteExpenseClaim(this.claimId).subscribe(data=>{
      this.deleteStatus=data;
      console.log(this.deleteStatus);
      if(this.deleteStatus==false)
        alert("not deleted!");
      else{
        
        alert("Deleted");
        this.route.navigate(['listClaim']);
      }
    });
    this.route.navigate['listClaim'];
   
  }
  listClaim() {
    this.service.listExpenseClaims(this.claimId).subscribe(p => this.expenseClaims =p);
  }
}
