import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Employee } from './model/employee';
import { ExpenseClaimModel } from './model/ExpenseClaim';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  addExpenseClaim(claims:ExpenseClaimModel){
    return this.http.post<ExpenseClaimModel>("http://localhost:9004/ems/claim/addclaim",claims);
    }
    getEmployee(empId:String){
      return this.http.get<Employee>("http://localhost:9004/ems/employee/"+empId);
    }
  getExpenseCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/expense");
  }

  getFinanceCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/finance");
  }

  getProjectCode(){
    return this.http.get<number[]>("http://localhost:9004/ems/project");
  }
  updateExpenseClaim(claims:ExpenseClaimModel){
    return this.http.put<ExpenseClaimModel>("http://localhost:9004/ems/claim/modifyclaim",claims);
    }
 
  flag : boolean = false;
  employee : Employee;
  private baseUrl = 'http://localhost:8888/employee';
  constructor(private http: HttpClient) {
   }
  saveEmployee(emp : Employee){
    console.log("saving employee");
    this.employee = emp;
    console.log(emp);
    console.log(sessionStorage);
    
  }
  
  createEmployee(employee: Employee): Observable<Employee> {
    let form=new FormData();
        form.append("empId", String(employee.empId));
        form.append("name",String(employee.name));
        form.append("pan", String(employee.pan));
        form.append("designation", String(employee.designation));
        form.append("domain", String(employee.domain));
        form.append("dateOfBirth", new Date(employee.dateOfBirth).toUTCString());
        form.append("email",String(employee.email));
        form.append("password", String(employee.password));
        form.append("salary", String(employee.salary));

    return this.http.post<Employee>(this.baseUrl+'/add', form);
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
  deleteId(empId: string) : Observable<string> {
    console.log(empId);
    let form=new FormData();
    form.append("empId", empId);
    console.log(form);
    return this.http.get<string>(this.baseUrl+"/delete?empId="+empId);
  }
  
  
  searchId(empId : string):Observable<Employee>{
    return this.http.get<Employee>(this.baseUrl+"/empId?empId="+empId);
  }
  searchDomain(domain : String):Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+"/domain?domain="+domain);
  }
  searchDesignation(designation : String):Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+"/designation?designation="+designation);
  }
  loginEmployee(empId : string, password : string):Observable<Employee>{
    //let form = new FormData();
    //form.append("empId",empId);
    //form.append("password",password);
    console.log("in service angular");

    return this.http.get<Employee>(this.baseUrl+"/login/?empId="+empId+"&password="+password);
  }
  listEmployee() {
    return this.http.get<Employee[]>(this.baseUrl+"/");
  }
  changePassword(empId: string, oldPassword: string, newPassword: string):Observable<Employee> {
    let form = new FormData();
    form.append("empId",empId);
    form.append("oldPassword",oldPassword);
    form.append("newPassword",newPassword);
    return this.http.get<Employee>(this.baseUrl+"/password/?empId="+sessionStorage.getItem('empId')+"&oldPassword="+oldPassword+"&newPassword="+newPassword);
  }
  addBank( bankName : string, accountNo : string, salary : string):Observable<any> {
    let form=new FormData();
        form.append("empId", String(this.employee.empId));
        form.append("bankName", String(bankName));
        form.append("accountNumber", String(accountNo));
    let params = new HttpParams().append('empId',this.employee.empId).append('bankName',bankName).append('accountNo',accountNo).append('salary', salary);
      return this.http.get(this.baseUrl+'/bank?empId='+sessionStorage.getItem('empId')+"&bankName="+bankName+"&accountNumber="+accountNo+"&salary="+salary);
    //return this.http.post(this.baseUrl+"/bank/"+this.employee.empId+"/"+bankName+"/"+accountNo);
  }

  deleteEmployee() {
    console.log("Logged out successfully!")
    this.employee = null;
    sessionStorage.clear();
    alert("Logged out!");
  }
  
}
