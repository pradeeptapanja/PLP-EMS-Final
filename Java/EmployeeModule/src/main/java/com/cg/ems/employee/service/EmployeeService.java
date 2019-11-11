package com.cg.ems.employee.service;

import java.util.List;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
import com.cg.ems.employee.exception.PasswordNotMatchedException;
/**
 * EmployeeService interface - contains method signatures of methods to be implemented in EmployeeServiceImpl class
 * @author Vivek Bothra
 * @version 1.0
 */
public interface EmployeeService {
	
	/**
	 * Function to add employee in database - when employee registers.
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	Employee addEmployee(Employee employee) throws EmployeeNotFoundException;
	
	/**
	 * Function to search employee by id from the database.
	 * @param empId
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	Employee searchEmployee(String empId) throws EmployeeNotFoundException;
	
	/**
	 * Function to search list of employees of particular designation from database
	 * @param designation
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException;
	
	/**
	 * Function to search list of employees of particular domain from database
	 * @param domain
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	List<Employee> searchDomain(String domain) throws EmployeeNotFoundException;
	
	/**
	 * Function to fetch all employees from database whose viewStatus is true
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	List<Employee> listEmployee() throws EmployeeNotFoundException;
	
	/**
	 * Function o change viewStatus of employee to false. 
	 * Soft deleting the employee information
	 */
	boolean deleteById(String empId) throws EmployeeNotFoundException;
	
	/**
	 * Function to update employee details - designation, domain , pan, salary
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;

	
	/**
	 *  Function to update employee details - password
	 * @param employee
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	Employee changePassword(Employee employee)throws EmployeeNotFoundException;
	
	/**
	 *  Function to update employee details - bankName, account number and salary
	 * @param emp
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	Employee addBankDetails(Employee emp) throws EmployeeNotFoundException;
	Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException;
	
	Employee updateDetails(Employee emp);
	
}
