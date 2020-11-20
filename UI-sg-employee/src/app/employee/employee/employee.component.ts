import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../Model/employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  public employees: Employee[];
  public error: boolean;
  public success: boolean;
  public detailsFlag: boolean;
  public registrationFlag: boolean = true;
  
  constructor(private service: EmployeeService) {
    
  }

  ngOnInit() {
  }

  //sumits the registration form 
  public onSubmit(employee: Employee) {
    this.service.save(employee).subscribe((emp : Employee) => {
      this.success = true;
    },
    error => {
      this.error = true;
    });
  }

  //function to subscribe get method form service
  public fetch(){
    this.service.findAll().subscribe((emp : Employee[]) => {
      this.employees = emp;
    });
  }

  // handle tab events
  public tabChanged(val : string){
    if(val == "detail"){
      this.detailsFlag = true;
      this.registrationFlag = false;
      this.fetch();
    }
   else{
    this.success = false;
    this.detailsFlag = false;
    this.registrationFlag = true;
    }
  }
}
