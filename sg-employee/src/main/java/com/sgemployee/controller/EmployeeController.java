package com.sgemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgemployee.model.Employee;
import com.sgemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	/**
	 * @return
	 * Rest api to find the employees in ascending order
	 */
	@GetMapping("/findAll")
	public List<Employee> findAllByOrderByFirstNameAsc() {
		return service.findAllByOrderByFirstNameAsc();
	}

	/**
	 * @param employee
	 * @return 
	 * Rest api to save employee
	 */
	@PostMapping("/save")
	public Employee save(@Valid @RequestBody Employee employee) {
		return service.save(employee);
	}
}
