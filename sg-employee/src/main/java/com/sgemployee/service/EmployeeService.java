package com.sgemployee.service;

import java.util.List;
import java.util.Optional;

import com.sgemployee.model.Employee;

public interface EmployeeService {

	public List<Employee> findAllByOrderByFirstNameAsc();
	public Employee save(Employee employee);
}
