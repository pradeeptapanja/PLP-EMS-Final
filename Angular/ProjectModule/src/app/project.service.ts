import { Injectable } from '@angular/core';
import { Project } from './project';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  
  adm : Admin;
  project: Project[]=[]
  constructor(public http:HttpClient) { }

  saveProject(pr : Project):Observable<Project> {
    return this.http.post<Project>("http://localhost:8880/project/add",pr);
  }

  searchProject(projectCode: number):Observable<Project> {
    return this.http.get<Project>("http://localhost:8880/project/projectCode/" + projectCode);
  }

  getProject(){
    return this.http.get<Project[]>("http://localhost:8880/project");
    //return this.http.get("http://localhost:9091/player");
  }

  modifyProject(project: Project): Observable<number> {
    console.log("5145");
    return this.http.post<number>("http://localhost:8880/project/update",project);

  }

  deleteProject(projectCode: number){
    return this.http.delete<boolean>("http://localhost:8880/project/delete/"+ projectCode);
  }

  loginAdmin(adminId: string, password: string): Observable<Admin> {
    return this.http.get<Admin>("http://localhost:8880/project/login?id=" + adminId + "&password=" + password);
  }

  saveAdmin(admin: Admin) {
    console.log("saving finance user");
    this.adm = admin;
    console.log(admin);
    console.log(sessionStorage);
  }

  deleteUser() {
    console.log("Logged out successfully!")
    this.adm = null;
    alert("Logged out!");
  }
}