import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Employee } from './model/employee';
import { Observable } from 'rxjs';
import { AdminClass } from './model/adminClass';
import { ExpenseClaimModel } from './model/ExpenseClaim';
@Injectable({
  providedIn: 'root'
})
export class ManageService {
  admin : AdminClass;
  private baseUrl = 'http://localhost:8888/employee';
  constructor(private http: HttpClient) { }

  listEmployee() {
    return this.http.get<Employee[]>(this.baseUrl+"/");
  }
  saveAdmin(admin : AdminClass){
    console.log("saving employee");
    this.admin = admin;
    console.log(admin);
    console.log(sessionStorage);
    
  }
  updateEmployee(pan: String, designation : String, domain : String, salary : number) {
    let form=new FormData();
        form.append("empId", sessionStorage.getItem('empId'));
        form.append("pan", String(pan));
        form.append("designation", String(designation));
        form.append("domain", String(domain));
        form.append("salary", String(salary))
        console.log(form);
        console.log(sessionStorage.getItem('empId'));
    return this.http.get<Employee>(this.baseUrl+'/update?empId='+sessionStorage.getItem('empId')+"&pan="+pan+"&designation="+designation+"&domain="+domain+"&salary="+salary);
  }
  searchId(empId : string):Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+"/empId?empId="+empId);
  }

  loginAdmin(adminId : string, password : string):Observable<any>{
    //let form = new FormData();
    //form.append("empId",empId);
    //form.append("password",password);
    console.log("in service angular");

    return this.http.get("http://localhost:8880/project/login?id="+adminId+"&password="+password);
  }
  deleteEmployee() {
    console.log("Logged out successfully!")
    this.admin = null;
    sessionStorage.clear();
    alert("Logged out!");
  }
  deleteId(empId: string) : Observable<string> {
    console.log(empId);
    let form=new FormData();
    form.append("empId", empId);
    console.log(form);
    return this.http.get<string>(this.baseUrl+"/delete?empId="+empId);
  }

  listExpenseClaims(claimId:number){
    return this.http.get<ExpenseClaimModel>("http://localhost:9004/ems/claim/"+claimId);
  }
  deleteExpenseClaim(id:number):Observable<boolean>{
    return this.http.delete<boolean>("http://localhost:9004/ems/claim/deleteclaim/"+id);
  }
}
