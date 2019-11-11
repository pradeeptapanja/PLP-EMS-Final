package com.cg.ems.expenseclaim.web;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.ems.expenseclaim.dto.Client;
import com.cg.ems.expenseclaim.dto.Employee;
import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;
import com.cg.ems.expenseclaim.service.ExpenseClaimService;

/**
 * Controller class 
 * @author Pritam Kumar Roy
 * @version 1.0
 */

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4201","http://localhost:4206","http://localhost:4615","http://localhost:4620","http://localhost:4205","http://localhost:4202"})
@RestController
@RequestMapping("/ems")
public class ExpenseClaimController {
	
	//Autowiring the service object
	@Autowired
	private ExpenseClaimService service;
	
	//Autowiring the rest template
	@Autowired
	RestTemplate restTemplate;
	
	//Logger object for logging various activities
		private static final Logger logger = LoggerFactory.getLogger(ExpenseClaimController.class);
	
		/**
		 * Pritam Kumar Roy
		 * Function to add an expenseclaim into the database.
		 * @param expenseclaim
		 * @return Integer
		 * @throws EmployeeNotFoundException
		 */
	@PostMapping(value = "/claim/addclaim",produces = "application/json",consumes = "application/json")
	public ResponseEntity<Integer> addClaim(@RequestBody ExpenseClaim claim) {
		logger.info("adding claim");
		int id= service.addClaim(claim);
		if (id == 0) {
			logger.error("ExpenseClaim not added");
			return new ResponseEntity("ExpenseClaim Not Added.", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			logger.info("ExpenseClaim added");
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
	}
	
	/**
	 * Function to search claim by id.
	 * @param claimId
	 * @return ExpenseClaim
	 */
	@GetMapping(value="/claim/{claimId}",produces = "application/json")
	public ResponseEntity<ExpenseClaim> findClaim(@PathVariable int claimId) throws ExpenseClaimNotFound{
		logger.info("searching claim by id");
		ExpenseClaim retrivedClaim=new ExpenseClaim();
		try {
			logger.info("ExpenseClaim found");
			retrivedClaim = service.viewClaim(claimId);
			return new ResponseEntity<ExpenseClaim>(retrivedClaim, HttpStatus.OK);
		} catch (ExpenseClaimNotFound ex) {
			logger.error("ExpenseClaim not found");
			System.out.println(ex.getMessage());
			return new ResponseEntity("Expenseclaim of claimid = "+claimId+"not found", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/claim")
	public ResponseEntity<List<ExpenseClaim>> allClaims(){
		List<ExpenseClaim> retrievedClaims = service.getAllClaims();
		if(retrievedClaims == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<List<ExpenseClaim>>(retrievedClaims, HttpStatus.OK);
	}
	
	/**
	 * Function to modify claim by id.
	 * @param claimId
	 * @return ExpenseClaim
	 * @throws ExpenseClaimNotFound 
	 */
	@PutMapping(value = "/claim/modifyclaim",produces = "application/json",consumes = "application/json")
	public ResponseEntity<ExpenseClaim> modifyClaim(@RequestBody ExpenseClaim claim) throws ExpenseClaimNotFound {
		logger.info("modifying claim by id");
		ExpenseClaim retrivedClaim=new ExpenseClaim();
		try {
			retrivedClaim = service.viewClaim(claim.getClaimId());
			if(retrivedClaim==null) {
			logger.info("ExpenseClaim not found");
			throw new ExpenseClaimNotFound("ExpenseClaim Not Found Claim Cannot Be modified");
			}
			else {
				logger.error("ExpenseClaim found");
				service.modifyClaim(claim);
				return new ResponseEntity<ExpenseClaim>(claim, HttpStatus.OK);
			}
		} catch (ExpenseClaimNotFound ex) {
			logger.error("ExpenseClaim modification not successful");
			System.out.println(ex.getMessage());
			return new ResponseEntity("Expenseclaim not modified", HttpStatus.BAD_REQUEST);
		}		
	}
	
	/**
	 * Function to delete claim by id.
	 * @param claimId
	 * @return boolean
	 * @throws ExpenseClaimNotFound 
	 */
	@DeleteMapping(value = "/claim/deleteclaim/{claimId}",produces = "application/json")
	public ResponseEntity<Boolean> deleteclaim(@PathVariable int claimId) throws ExpenseClaimNotFound {
		logger.info("deleting claim by id");
		ExpenseClaim retrivedClaim=service.viewClaim(claimId);
		if(retrivedClaim==null) {
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}else {
			service.deleteClaim(claimId);
			return  new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}		
	}
	
	/**
	 * Function to search employee by id.
	 * @param employeeId
	 * @return Employee
	 */
	@GetMapping(value = "/employee/{employeeId}",produces = "application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId) {
		logger.info("searching employee by employeeid"); //empId?empId=
		Employee retrivedEmployee =restTemplate.getForObject("http://ems-employee-service/employee/id/" + employeeId,Employee.class);
		if (retrivedEmployee==null) {
			return new ResponseEntity("Employee not found", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Employee>(retrivedEmployee,HttpStatus.OK);
		}
		//return retrivedEmployee;
	}
	
	/**
	 * Function to list expenseid.
	 * @return List<Integer>
	 */
	@GetMapping(value = "/expense",produces = "application/json")
	public List<Integer> getExpense() {
		logger.info("searching list of expenseid");
		List<Integer> expenseIds =Arrays.asList(restTemplate.getForObject("http://ems-expense-service/expense/allId",Integer[].class));
		return expenseIds;
	}
	
	/**
	 * Function to list of clientid.
	 */
	@GetMapping(value = "/client",produces = "application/json")
	public int getClient() {
		Client retrivedClient =restTemplate.getForObject("http://product-add-service/product//j",Client.class);
		return retrivedClient.getClientCode();
	}
	
	/**
	 * Function to list of projectid.
	 * @return List<Integer>
	 */
	@GetMapping(value = "/project",produces = "application/json")
	public List<Integer> getProject() {
		logger.info("searching list of projectid");
		List<Integer> projectIds =Arrays.asList(restTemplate.getForObject("http://ems-project-service/project/allId",Integer[].class));
		return projectIds;
	}
	/**
	 * Function to list of projectid.
	 * @return List<Integer>
	 */ 
	@GetMapping(value = "/finance",produces = "application/json")
	public List<String> getFinance() {
		logger.info("searching list of financeid");
		List<String> financeIds =Arrays.asList(restTemplate.getForObject("http://ems-finance-service/finance-team/getids",String[].class));
		return financeIds;
	}
	
}
