/**
 * Controller class for receiving client request and sending the app response
 * contains mapping and application methods to process the client request
 */
package com.cg.ems.finance.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;
import com.cg.ems.finance.service.FinanceUserService;
import com.cg.ems.finance.service.FinanceUserServiceImpl;

/**
 * @author Panja
 * @version 1.0
 */

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4201","http://localhost:4206","http://localhost:4615","http://localhost:4620","http://localhost:4205","http://localhost:4202"})
@RestController
@RequestMapping("/finance-team")
public class controller {

	static Logger financeUserControllerLogger;

	static {
		financeUserControllerLogger = Logger.getLogger(FinanceUserServiceImpl.class);
	}
	
	/**
	 * for creating financeUserService object everytime controller is called
	 */
	@Autowired
	FinanceUserService financeUserService;

	/**
	 * Method for accepting the client request for logging in
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/login/{userId}/{password}
	 * @param userId
	 * @param password
	 * @return FinanceUser
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	@GetMapping(value = "/login/{userId}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceUser loginFinanceUser(@PathVariable String userId, @PathVariable String password)
			throws InvalidFinanceUserLoginCredentialsException {
		financeUserControllerLogger.info("requested log in method by user id: " + userId);
		return financeUserService.authenticateFinanceUser(userId, password);
	}

	/**
	 * Method for accepting the client request for registering new user
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/register
	 * @param newFinanceUser
	 * @return String
	 */
	@PostMapping(value = "/register", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public String registerFinanceUser(@RequestBody FinanceUser newFinanceUser) {
		financeUserControllerLogger.info("requested register new member method by user id: " + newFinanceUser.getFinanceUserId());
		return financeUserService.addFinanceUser(newFinanceUser);
	}

	/**
	 * Method for accepting the client request for changing user password
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/update-password
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return FinanceUser
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	@GetMapping(value = "/update-password")
	public FinanceUser updateFinanceUserPassword(@RequestParam String userId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		financeUserControllerLogger.info("requested change password method by user id: " + userId);
		return financeUserService.changeFinanceUserPassword(userId, oldPassword, newPassword);
	}
	
	/**
	 * Method for accepting the client request for changing user mobile
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/update-mobile/{financeUserId}/{mobile}
	 * @param financeUserId
	 * @param mobile
	 * @return int
	 */
	@PutMapping(value = "/update-mobile/{financeUserId}/{mobile}")
	public int updateMobile(@PathVariable String financeUserId, @PathVariable String mobile) {
		financeUserControllerLogger.info("requested change mobile method by user id: " + financeUserId);
		return financeUserService.changeFinanceUserMobile(financeUserId, mobile);
	}
	
	/**
	 *  Method for accepting the client request for changing user email
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/update-mobile/{financeUserId}/{email}
	 * @param financeUserId
	 * @param email
	 * @return int
	 */
	@PutMapping(value = "/update-email/{financeUserId}/{email}")
	public int updateEMail(@PathVariable String financeUserId, @PathVariable String email) {
		financeUserControllerLogger.info("requested change email method by user id: " + financeUserId);
		return financeUserService.changeFinanceUserEMail(financeUserId, email);
	}

	/**
	 * Method for accepting the client request for fetching all finance user ids
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/getids
	 * @return List<String>
	 */
	@GetMapping(value = "/getids", produces = "application/json")
	public List<String> getAllIds() {
		financeUserControllerLogger.info("requested fetch list of all finance user ids method");
		return financeUserService.getAllUserIds();
	}

	/**
	 * Method for accepting the client request for fetching the list of claims
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/getclaims
	 * @return List<ExpenseClaim>
	 */
	@GetMapping(value = "/getclaims", produces = "application/json")
	public List<ExpenseClaim> getAllClaims() {
		financeUserControllerLogger.info("requested fetch list of all claims method");
		return financeUserService.getAllClaims();
	}

	/**
	 * Method for accepting the client request for approving claim
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/claimapprove/{claimId}
	 * @param claimId
	 * @return int
	 */
	@PutMapping(value = "/claimapprove/{claimId}")
	public int approveClaim(@PathVariable int claimId) {
		financeUserControllerLogger.info("requested approve claim method for claim id: " + claimId);
		return financeUserService.approveClaim(claimId);
	}

	/**
	 * Method for accepting the client request for rejecting claim
	 * and invoking service layer method to perform the operation
	 * 
	 * URL: http://localhost:7100/finance-team/claimreject/{claimId}
	 * @param claimId
	 * @return int
	 */
	@PutMapping(value = "/claimreject/{claimId}")
	public int rejectClaim(@PathVariable int claimId) {
		financeUserControllerLogger.info("requested reject claim method for claim id: " + claimId);
		return financeUserService.rejectClaim(claimId);
	}
}
