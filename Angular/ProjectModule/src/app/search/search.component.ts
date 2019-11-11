import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  project: Project
  projectCode: number;
  
  constructor(private service:ProjectService) { 
    this.project=new Project();
  }

  ngOnInit() {
    //this.project=new Project();
  }
  findProject(){
 this.service.searchProject(this.project.projectCode).subscribe(data => this.project = data);
    
  }

}
