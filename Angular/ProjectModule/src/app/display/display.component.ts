import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../project.service';
import { Project } from '../project';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {
  projects: Project[];
  constructor(private service: ProjectService) { }

  ngOnInit() {
  this.service.getProject().subscribe(p=> this.projects  = p);
  }
}