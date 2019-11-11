import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-mobile',
  templateUrl: './update-mobile.component.html',
  styleUrls: ['./update-mobile.component.css']
})
export class UpdateMobileComponent implements OnInit {

  userId: string;
  mobile: string;
  finance: string

  constructor(private service: FinanceuserService, private router: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('status') === 'false') {
      this.router.navigate(['login']);
    }
    this.userId = sessionStorage.getItem('financeUserId');
  }

  changeMobile() {

    let fin = this.service.updateFinanceUserMobile(this.mobile).subscribe(data => {
      this.finance = data;
      if (this.finance != null) {
        alert("mobile changed successfully!");
        this.router.navigate(['claim']);
      }
    }
    );
  }
}
