import { Component, OnInit } from '@angular/core';
import { finance } from '../model/finance';
import { FinanceuserService } from '../financeuser/financeuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  finance: finance = new finance();
  fin : finance = new finance();
  public barLabel: string = "Password strength:";
  public myColors = ['#DD2C00', '#FF6D00', '#FFD600', '#AEEA00', '#00C853'];
  submitted = false;
  //login : LoginComponent;
  constructor(private financeService: FinanceuserService, private router: Router) {
    
   }
  ngOnInit() {
  }

  newFinanceUser(): void {
    this.submitted = false;
    this.finance = new finance();
  }

  registerFinanceUser() {
    this.financeService.createFinanceUser(this.finance)
      .subscribe(data => 
        this.fin, error => console.log(error));
      // {
      //   this.fin = data;
        if(this.fin == null)
          this.router.navigate(['register']);
        else{
            this.router.navigate(['login']);
            alert("Registered Successfully");
        }
    }
    //);
    
  

  onSubmit() {
    this.submitted = true;
    this.registerFinanceUser();
  }
}
