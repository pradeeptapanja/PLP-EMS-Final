import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ManageService } from '../manage.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private appComponent : AppComponent, private service : ManageService, private router : Router) { }

  ngOnInit() {
    this.service.deleteEmployee();
    this.appComponent.tabFlag();
    this.router.navigate(['login']);
  }

}
