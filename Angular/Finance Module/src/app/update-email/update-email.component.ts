import { Component, OnInit } from '@angular/core';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-update-email',
  templateUrl: './update-email.component.html',
  styleUrls: ['./update-email.component.css']
})
export class UpdateEmailComponent implements OnInit {

  userId: string;
  email: string;
  finance: string;

 

  constructor(private service: FinanceuserService, private router: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem('status') === 'false') {
      this.router.navigate(['login']);
    }
    this.userId = sessionStorage.getItem('financeUserId');

  }

  
  changeEmail() {

    let fin = this.service.updateFinanceUserEmail(this.email).subscribe(data => {
      this.finance = data;
      if (this.finance != null) {
        alert("email changed successfully!");
        this.router.navigate(['claim']);
      }
    }
    );
  }
}
