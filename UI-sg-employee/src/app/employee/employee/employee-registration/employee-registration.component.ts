import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Employee } from '../../Model/employee';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.scss']
})
export class EmployeeRegistrationComponent implements OnInit ,OnChanges{

  @Output()
  public onChange = new EventEmitter<Employee>();

  @Input()
  public success : boolean;

  @Input()
  public error : boolean;
  
  public employeeForm : FormGroup;
  public isValid: boolean = true;

  constructor(private fb: FormBuilder) {
    this.createForm();
   }

  ngOnChanges(changes: SimpleChanges): void {
    this.isValid = true;
  }

  ngOnInit() {
  }

  public onSubmit(){
    if(this.employeeForm.valid){
      this.onChange.emit(this.employeeForm.value);
      this.isValid = true;
    }else{
      if(!this.employeeForm.touched){
          this.isValid = false;
      }
    }
  }

  public cancel(){
    this.success = false;
    this.error = false;
  }

  createForm() {
    this.employeeForm = this.fb.group({
      firstName: ['', Validators.required ],
      lastName: ['', Validators.required ],
      gender: ['', Validators.required ],
      dob: ['', Validators.required ],
      department: ['', Validators.required ]
    });
  }
}
