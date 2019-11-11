/**
 * 
 */
package com.cg.ems.expense.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.ems.expense.dto.Expense;

/**
 * @author Anurag Kumar
 * @version 1.0
 * 
 */
public interface ExpenseRepo extends JpaRepository <Expense, Integer> {

	@Modifying
	@Query("UPDATE Expense e SET e.expenseType=:eT, e.expenseDescription=:eD WHERE e.expenseCode=:eC")
	int modifyExpense(int eC, String eT, String eD); 	
	
}