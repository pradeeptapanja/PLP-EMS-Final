import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../model/employee';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  employee: Employee = new Employee();
  empIdStatus : boolean = false;
  nameStatus : boolean = false;
  panStatus : boolean = false;
  designations : String[] = ['Analyst','Senior Analyst','Consultant','Associate Consultant','Senior Consultant','Manager','Senior Manager'];
  domains : String[] = ['AppsEurope', 'AppsTwo', 'Sogeti', 'AppsUS', 'SAPW'];
  dateOfJoining : any = '';
  dateOfBirth : any = '';
  designationStatus : boolean = false;
  domainStatus : boolean = false;
  salaryStatus : boolean = false;
  passwordStatus : boolean = false;
  emailStatus : boolean = false;
  emp : Employee;
  public barLabel: string = "Password strength:";
  public myColors = ['#DD2C00', '#FF6D00', '#FFD600', '#AEEA00', '#00C853'];
  submitted = false;
  angForm: FormGroup;
  //login : LoginComponent;
  constructor(private employeeService: EmployeeService, private router: Router, private fb: FormBuilder) {
    this.createForm();
   }

  ngOnInit() {
  }
  createForm() {
    this.angForm = this.fb.group({
         name: ['', Validators.required ]
    });
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  registerEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(data => {
        this.emp = data;
        if(this.emp.empId == null)
          this.router.navigate(['register']);
        else{
            this.router.navigate(['login']);
            alert("Registered Successfully");
        }
    });
    //this.employee = new Employee();
    //this.toastr.success('Employee Added Successfully!', 'Congratulations!');
            //this.router.navigate(['/login']);
            //this.login.ngOnInit();
        // if(emp!=null){
        //     alert("Employee successfully registered!");
        //     this.router.navigate(['login']);
        // }else{
        //   alert("Employee could not be registered!");
        //   this.router.navigate(['register']);
        // }
  }

  onSubmit() {
    this.submitted = true;
    this.registerEmployee();
  }

}
