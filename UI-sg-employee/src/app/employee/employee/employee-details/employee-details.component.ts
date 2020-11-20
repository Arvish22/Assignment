import { Component, Input, OnInit } from '@angular/core';
import { Employee } from '../../Model/employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit {

  @Input()
  public employees : Employee[];

  constructor() { }

  ngOnInit() {
  }

}
