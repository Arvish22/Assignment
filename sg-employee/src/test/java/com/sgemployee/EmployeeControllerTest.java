package com.sgemployee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sgemployee.model.Employee;

/**
 * @author 
 * Test Controller class 
 */
public class EmployeeControllerTest extends SgEmployeeApplicationTests{



	/**
	 * Test case to handle successfull save
	 * @throws Exception
	 * 
	 */
	@Test
	public void createEmployee() throws Exception {

		MockMvc mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/api/save";
		Employee employee = new Employee();
		employee.setId((long) 3);
		employee.setFirstName("Ginger");
		employee.setLastName("wills");
		employee.setDob(new Date());
		employee.setDepartment("fire");
		String inputJson = super.mapToJson(employee);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		equals(content.contains(employee.getFirstName()));
	}

	/**
	 * Test case to handle successfull fetch
	 * @throws Exception
	 */
	@Test
	public void getEmployeeList() throws Exception {

		MockMvc mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/api/findAll";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Employee[] emplist = mapFromJson(content, Employee[].class);
		assertTrue(emplist.length == 0);
	}



	/**
	 * Test case to handle validation while saving
	 * @throws Exception
	 */
	@Test
	public void createEmployeeBadRequest() throws Exception {

		MockMvc mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/api/save";
		Employee employee = new Employee();
		employee.setId((long) 3);
		employee.setFirstName("Gin  ger");
		employee.setLastName("wills");
		employee.setDob(new Date());
		employee.setDepartment("fire");
		String inputJson = super.mapToJson(employee);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}
}
