package com.sgemployee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgemployee.model.Employee;
import com.sgemployee.repository.EmployeeRepository;
import com.sgemployee.service.EmployeeService;

/**
 * @author 
 * Service layer for business logic
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;


	/**
	 *Method to call repository and find the employees in ascending order
	 */
	@Override
	public List<Employee> findAllByOrderByFirstNameAsc() {
		return repository.findAllByOrderByFirstNameAsc();
	}

	/**
	 * Method to call repository to save employee object
	 *
	 */
	@Override
	public Employee save(Employee employee) {
		return repository.save(employee);
	}
}
