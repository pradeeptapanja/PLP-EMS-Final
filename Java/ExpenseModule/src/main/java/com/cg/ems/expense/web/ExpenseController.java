package com.cg.ems.expense.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.expense.dto.Admin;
import com.cg.ems.expense.dto.Expense;
import com.cg.ems.expense.exception.AdminNotFoundException;
import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;
import com.cg.ems.expense.service.AdminService;
import com.cg.ems.expense.service.ExpenseService;

/**
 * @author admin
 *
 */
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4201","http://localhost:4206","http://localhost:4615","http://localhost:4620","http://localhost:4205","http://localhost:4202"})
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService service;

	@Autowired
	private AdminService aService;

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Expense addNewExpense(@RequestBody Expense expense) throws WrongValidationException {

		try {
			return service.addExpense(expense);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@GetMapping(produces = "application/json")
	public List<Expense> getAllExpenses() {
		return service.displayAllExpense();
	}

	@GetMapping(value = "/allId", produces = "application/json")
	public List<Integer> getAllExpensesId() {
		List<Integer> ids = service.displayAllId();

		return ids;
	}

	@GetMapping(value = "/expenseCode/{id}", produces = "application/json")
	public Expense searchByExpenseCode(@PathVariable int id) throws WrongIDException {
		return service.displayExpense(id);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public boolean removeByExpenseCode(@PathVariable int id) throws WrongIDException {
		return service.deleteExpense(id);
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public String updateExpense(@RequestBody Expense expense) throws WrongIDException, WrongValidationException {
		int temp = service.modifyExpense(expense);
		if (temp == 1)
			return "Successfully modified";
		else
			return "Couldn't modify";
	}

	@GetMapping(value = "/login/{id}/{password}", produces = "application/json")
	public Admin loginAdmin(@PathVariable ("id") String id, @PathVariable("password") String password) {
		// logger.info("Trying for Login");
		try {
			// logger.info("Successful Employee login");
			return aService.login(id, password);
		} catch (AdminNotFoundException ex) {
			// logger.error("Employees login not successful ");
			System.out.println(ex.getMessage());
			return null;
		}
	}
//
//	@PutMapping(value = "/updatePassword")
//	public String updateAdmin(@RequestParam("id") String id, @RequestParam("oldPassword") String oldPassword,
//			@RequestParam("newPassword") String newPassword) {
//		// logger.info("Trying for Login");
//		try {
//			// logger.info("Successful Employee login");
//			if (aService.updatePassword(id, oldPassword, newPassword) == 1) {
//				System.out.println("Successfully updated password");
//				return "Successfully updated password";
//			} else
//				return "couldn't update";
//		} catch (AdminNotFoundException ex) {
//			// logger.error("Employees login not successful ");
//			return ex.getMessage();
//		}
	//}
}