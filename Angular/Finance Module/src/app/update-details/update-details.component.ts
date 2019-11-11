import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-details',
  templateUrl: './update-details.component.html',
  styleUrls: ['./update-details.component.css']
})
export class UpdateDetailsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  updatePassword(){
    this.router.navigate(['update']);
  }

  updateEmail(){
    this.router.navigate(['email']);
  }
  
  updateMobile(){
    this.router.navigate(['mobile']);
  }
}
