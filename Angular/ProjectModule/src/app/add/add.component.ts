import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ProjectService } from '../project.service';
import { Project } from '../project';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  project:Project;
  project1: Project;
  domains : String[] = ['AppsTwo', 'Sogeti', 'AWS', 'AppsUSA', 'AppsTesting', 'Maintainance'];

  constructor(private service: ProjectService, private route:Router) {
    this.project=new Project();
  }

  ngOnInit() {
  }

  addProject() {
    this.service.saveProject(this.project).subscribe(p => {
        this.project1 = p;
        //this.project = new Project();
        if(this.project1 != null){
          alert("Project Added")
          this.route.navigate(['display']);
        } else{
          alert("Project Not Added")
          this.route.navigate(['add']);
        }
      });
          
  }
}
