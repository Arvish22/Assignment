import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './Model/employee';
import {NgForm} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService{

  constructor(private http:HttpClient) { }

  //(Get method) function to consume rest end for find all
  public findAll(){
    return this.http.get<Employee[]>("http://localhost:8080/api/findAll");
  }

  //(Post method) function to consume rest end for save
  public save(employee : Employee){
    return this.http.post<Employee>("http://localhost:8080/api/save",employee);
  }
}
