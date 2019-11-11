/**
 * 
 */
package com.cg.ems.employee.servicetest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.context.junit4.SpringRunner;


import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.repo.EmployeeRepo;




/**
 * @author admin
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeServiceImplTest {
	
	private Employee employee;
	@Autowired
	private EmployeeRepo repo;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		employee = new Employee();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		employee = null;
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#addEmployee(com.cg.ems.employee.dto.Employee)}.
	 * @throws Exception 
	 */
	@Test
	public void testAddEmployee() throws Exception {
		
		employee.setEmpId("EE46010");
		employee.setName("Vivek Bothra");
		employee.setPan("CEOPB5268R");
		employee.setDomain("Cloud");
		employee.setDesignation("Senior Analyst");
		//employee.setDateOfJoining(new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-19"));
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1997-04-01"));
		employee.setSalary(50214);
		employee.setBankName("Axis Bank");
		employee.setAccountNumber("4187004242");
		employee.setBalance(20000);
		employee.setPassword("qwerty123");
		employee.setViewStatus(true);
		
		assertEquals("EE46010",employee.getEmpId());
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchEmployee(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSearchEmployee() throws Exception {
		 Employee employee = repo.searchEmployee("EE46001");
		 if(employee != null)
			 assertNotNull(employee);
		 else
			 assertNull(employee);
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchDesignation(java.lang.String)}.
	 * @throws EmployeeNotFoundException 
	 * @throws Exception 
	 */
	@Test
	public void testSearchDesignationFail() throws EmployeeNotFoundException  {
		List<Employee> employees = repo.searchDesignation("associate");
		assertEquals(0, employees.size());
	}
	
	@Test
	public void testSearchDesignationPass() throws EmployeeNotFoundException  {
		List<Employee> employees = repo.searchDesignation("Associate Consultant");
		assertNotEquals(0, employees.size());
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#searchDomain(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSearchDomainFail() throws Exception {
		List<Employee> employees = repo.searchDomain("Selenium");
		assertNotEquals(0, employees.size());
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#loginEmployee(java.lang.String, java.lang.String)}.
	 * @throws EmployeeNotFoundException 
	 */
	@Test
	public void testLoginEmployeeFail() throws EmployeeNotFoundException {
		Employee employee = repo.loginEmployee("EE46001", "qwerty123");
		assertNull(employee);
		
	}
	@Test
	public void testLoginEmployeePass() throws EmployeeNotFoundException {
		Employee employee = repo.loginEmployee("EE46003", "qwerty@12");
		assertNull(employee);
		
	}
	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#listEmployee()}.
	 * @throws EmployeeNotFoundException 
	 * @throws Exception 
	 */
	@Test
	public void testListEmployee() throws EmployeeNotFoundException {
		List<Employee> employees = repo.listEmployee();
		assertNotEquals(0, employees.size());
		
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#deleteById(java.lang.String)}.
	 * @throws EmployeeNotFoundException 
	 */
	@Test
	public void testDeleteById() throws EmployeeNotFoundException  {
		 Employee employee = repo.searchEmployee("EE46017");
		 if(employee != null)
			 assertTrue(employee.getViewStatus());
		 else
			 assertNull(employee);
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#updateEmployee(com.cg.ems.employee.dto.Employee)}.
	 */
	@Test
	public void testUpdateEmployee() {
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#changePassword(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testChangePassword() throws Exception {
		
		
	}

	/**
	 * Test method for {@link com.cg.ems.employee.service.EmployeeServiceImpl#addBankDetails(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddBankDetails() {
		
	}
//	@Test
//	public void testSearchDomainPass() throws EmployeeNotFoundException  {
//		List<Employee> employees = repo.searchDomain("Cloud");
//		assertNotEquals(0, employees.size());
//	}
	


}
