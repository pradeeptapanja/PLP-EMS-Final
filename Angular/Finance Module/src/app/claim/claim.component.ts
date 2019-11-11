import { Component, OnInit } from '@angular/core';
import { ClaimModel } from '../model/claim';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css']
})
export class ClaimComponent implements OnInit {
  title = 'List of Claims';
  claims:ClaimModel[];
  claim:ClaimModel;
  p: Number = 1;
  count : Number = 3;
  constructor(private service : FinanceuserService, private route:Router) {
     this.claim = new ClaimModel;  
  }


  ngOnInit() {
   this.service.listClaims().subscribe(data=>this.claims=data);
  }

  approveClaim(clm: ClaimModel){
    // console.log(blogId)
    let claimId = clm.claimId;
    this.service.approveClaims(claimId).subscribe(val => {
      clm.status = 'Approved';
    });
  }
  rejectClaim(clm: ClaimModel){

    let claimId = clm.claimId;
    this.service.rejectClaims(claimId).subscribe(val => {
      clm.status = 'Rejected';
    });
  }

}
