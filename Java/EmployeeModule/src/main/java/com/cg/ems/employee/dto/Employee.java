package com.cg.ems.employee.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Employee entity 
 * @author Vivek Bothra
 * @version 1.0
 */
@Entity
@Table(name = "employee")
@NamedQuery(name = "byId", query = "SELECT emp FROM Employee emp WHERE emp.empId = :empId")
@NamedQuery(name = "listAll", query = "SELECT emp FROM Employee emp")
@NamedQuery(name = "delete", query = "DELETE FROM Employee emp WHERE emp.empId = :empId")
//@NamedQuery(name = "updatePassword", query = "UPDATE Employee emp SET emp.emp_password = :password WHERE emp.emp_id = :empid")
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	@NotNull(message = "Employee ID cannot be null")
	@Pattern(regexp="EE[A-Z0-9]{5}")
	private String empId;
	
	@Column(name = "emp_name", length = 15)
	@NotNull(message = "Employee Name cannot be null")
	@Pattern(regexp="[A-Z][a-z]{3,}")
	private String name;
	
	@Column(name = "emp_pan", length = 10)
	@NotNull(message = "Employee PAN number cannot be null")
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]")
	private String pan;
	
	@Column(name = "emp_designation", length = 125)
	@NotNull(message = "Employee Designation cannot be null")
	private String designation;
	
	@Column(name = "emp_domain", length = 20)
	@NotNull(message = "Employee Domain cannot be null")
	private String domain;
	
	
	@Column(name = "emp_dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Column(name = "emp_salary")
	@NotNull(message = "Employee Salary cannot be null")
	private double salary;
	
	@Column(name = "emp_email", length = 25)
	@NotNull(message = "Employee Email ID cannot be null")
	//@Pattern(regexp="[\\w_]+@[a-z]{3,20}.[a-z]{2,4}")
	private String email;
	
	@Column(name = "emp_bankname", length = 20)
	private String bankName;
	
	@Column(name = "emp_accountno", length = 10)
	//@Pattern(regexp = "")
	private String accountNumber;
	
	@Column(name = "emp_balance")
	private double balance;
	
	@Column(name = "emp_password")
	@NotNull(message = "Employee password cannot be null")
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String password;
	
	@Column(name = "emp_view")
	private boolean viewStatus;
	
	public boolean getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(boolean viewStatus) {
		this.viewStatus = viewStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMailId() {
		return email;
	}

	public void setMailId(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
