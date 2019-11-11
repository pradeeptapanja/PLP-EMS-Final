package com.cg.ems.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.employee.dto.Employee;
import com.cg.ems.employee.exception.EmployeeNotFoundException;
/**
 * EmployeeRepo interface - extends JpaRepository, contains namedQuery implementing methods.
 * @author Vivek Bothra
 * @version 1.0
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee , String>{
	

	/**
	 * Function to search employee by id from the database.
	 * @param empId
	 * @return AND emp.viewStatus = TRUE
	 * @throws EmployeeNotFoundException
	 */
	@Query("SELECT emp FROM Employee emp WHERE emp.empId = :empId AND emp.viewStatus = TRUE")
	Employee searchEmployee(String empId) throws EmployeeNotFoundException;
	
	/**
	 * Function to search list of employees of particular designation from database
	 * @param designation
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Query("SELECT emp FROM Employee emp WHERE emp.designation = :designation AND emp.viewStatus = TRUE")
	List<Employee> searchDesignation(String designation) throws EmployeeNotFoundException;
	
	/**
	 * Function to search list of employees of particular domain from database
	 * @param domain
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	@Query("SELECT emp FROM Employee emp WHERE emp.domain = :domain AND emp.viewStatus = TRUE")
	List<Employee> searchDomain(String domain) throws EmployeeNotFoundException;
	
	/**
	 * Function to fetch all employees from database whose viewStatus is true
	 * @return  
	 * @throws EmployeeNotFoundException
	 */
	@Query("SELECT emp FROM Employee emp WHERE emp.viewStatus = TRUE")
	List<Employee> listEmployee() throws EmployeeNotFoundException;
	
	/**
	 * Function o change viewStatus of employee to false. 
	 * Soft deleting the employee information
	 */
	@Query("DELETE FROM Employee emp WHERE emp.empId = :empId")
	void deleteById(String empId);
	
	/**
	 * Function to authenticate user credentials - empId and password.
	 * @param empId
	 * @param password
	 * @return  AND emp.viewStatus = TRUE
	 * @throws EmployeeNotFoundException
	 */
	@Query("SELECT emp FROM Employee emp WHERE emp.empId = :empId AND emp.password = :password AND emp.viewStatus = TRUE")
	Employee loginEmployee(String empId, String password) throws EmployeeNotFoundException;

	

}
