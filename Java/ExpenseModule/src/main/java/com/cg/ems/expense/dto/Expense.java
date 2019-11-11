/**
 * 
 */
package com.cg.ems.expense.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Anurag Kumar
 * @version 1.0
 */
@Entity
@GenericGenerator(name = "expense_code_seq", strategy = "increment")
@Table(name = "expense")
public class Expense {
	
	@Id
	@Column(name = "expense_code")
	@GeneratedValue(generator = "expense_code_seq", strategy = GenerationType.SEQUENCE)
	private int expenseCode;
	
	@Column(name = "expense_type")
	@Pattern(regexp = "[A-Z][a-z]{2,15}")
	@NotBlank(message = "Type is mandatory, cannot be null")
	private String expenseType;
	
	@Column(name = "expense_description")
	@Pattern(regexp = "[A-Za-z0-9_ ,.]{15,100}")
	@NotBlank(message = "Description is mandatory, cannot be null")
	private String expenseDescription;

	public int getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
}
