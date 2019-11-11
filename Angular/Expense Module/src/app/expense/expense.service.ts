import { Injectable } from '@angular/core';
import { Expense } from '../expensemodel/expense';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../adminmodel/admin';


@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  
  adm: Admin;

  private baseUrl = 'http://localhost:8182/expense';
  constructor(public http: HttpClient) { }

  saveExpense(exp: Expense):Observable<Expense>{
    return this.http.post<Expense>(this.baseUrl+'/add', exp);
  }

  findExpense(expCode: number):Observable<Expense>{
    return this.http.get<Expense>(this.baseUrl+"/expenseCode/"+expCode);
  }

  listExpenses(){
    return this.http.get<Expense[]>(this.baseUrl+"/");
  }
  
  modifyExpense(exp: Expense):Observable<String>{
    return this.http.put<String>(this.baseUrl+"/update/",exp);
  }

  deleteExpense(expCode: number){
    return this.http.delete<boolean>(this.baseUrl+"/delete/"+expCode);
  }

  loginAdmin(adminId:string, password:String):Observable<Admin>{
    return this.http.get<Admin>("http://localhost:8880/project/login?id="+adminId+"&password="+password);
  }

  saveAdmin(admin:Admin){
    this.adm = admin;
  }

  deleteUser(){
    this.adm = null;
    alert("logged out !");
  }
}