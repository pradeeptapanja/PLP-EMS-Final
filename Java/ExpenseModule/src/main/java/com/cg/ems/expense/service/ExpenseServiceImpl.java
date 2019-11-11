/**
 * 
 */
package com.cg.ems.expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;
import com.cg.ems.expense.repo.ExpenseRepo;

/**
 * @author admin
 *
 */
@Service
@Transactional(rollbackOn = {WrongIDException.class,WrongValidationException.class})
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepo repo;

	@Override
	public Expense addExpense(Expense expense) throws WrongValidationException {

		Expense expenseLocal = repo.save(expense);
		if (expenseLocal != null)
			return expenseLocal;
		else
			throw new WrongValidationException("Input in wrong format");
	}

	@Override
	public List<Expense> displayAllExpense() {

		List<Expense> displayAll = repo.findAll();

		return displayAll;
	}

	@Override
	public Expense displayExpense(int expCode) throws WrongIDException {

		Expense expenseLocal = repo.findById(expCode).get();

		if (expenseLocal != null)
			return expenseLocal;
		else
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
	}

	@Override
	public boolean deleteExpense(int expCode) throws WrongIDException {
		try {
			repo.deleteById(expCode);
			return true;
		} catch (Exception e) {
			throw new WrongIDException("No Expense with Expense Code " + expCode + " found");
		}
	}

	@Override
	public List<Integer> displayAllId() {

		List<Integer> expId = new ArrayList<Integer>();
		List<Expense> displayAll = repo.findAll();

		for (Expense exp : displayAll) {
			expId.add(exp.getExpenseCode());
		}
		return expId;
	}

	@Override
	public int modifyExpense(Expense expense) throws WrongIDException, WrongValidationException {
		int expCode = expense.getExpenseCode();
		String expType = expense.getExpenseType();
		String expDescription = expense.getExpenseDescription();

		if (repo.findById(expCode) != null) {
			int expenseLocal = repo.modifyExpense(expCode, expType, expDescription);

			if (expenseLocal != 0)
				return expenseLocal;
			else
				throw new WrongValidationException("Input in wrong format");
		} else
			throw new WrongIDException("Expense with code " + expCode + " not found");
	}
}