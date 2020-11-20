package com.sgemployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgemployee.model.Employee;

/**
 * @author 
 * Repository to handle transaction
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	/**
	 * @return
	 * Query method to fetch employee list in ascending order
	 */
	public List<Employee> findAllByOrderByFirstNameAsc(); 
	
}
