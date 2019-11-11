import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  project: Project;
  project1: number;

  constructor(private service: ProjectService, private route: Router) {
    console.log("0");
    this.project = new Project();
  }

  ngOnInit() { }

  updateProject() {
    console.log("1");
    this.service.modifyProject(this.project).subscribe(p => {
      this.project1 = p;
      console.log("514");
      if (this.project1 != -1) { console.log(55); alert("Successfully Modified"); }
      else 
        alert("Not Modified");
    });
    // console.log("2");
    // this.project = new Project();
    // console.log("3");
    // if (this.project1 == "Successfull Modification") { console.log(55); alert("Successfully Modified"); }
    // console.log("4");
     this.route.navigate(['display']);

  }
}
