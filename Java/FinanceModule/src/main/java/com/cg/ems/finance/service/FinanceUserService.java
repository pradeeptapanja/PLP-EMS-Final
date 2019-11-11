/**
 * Service layer interface containing business logic
 */
package com.cg.ems.finance.service;

import java.util.List;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;

/**
 * @author Panja
 * @version 1.0
 */
public interface FinanceUserService {
	/**
	 * method for validating login id and password
	 * 
	 * @param loginId
	 * @param loginPassword
	 * @return FinanceUser
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	FinanceUser authenticateFinanceUser(String loginId, String loginPassword)
			throws InvalidFinanceUserLoginCredentialsException;

	/**
	 * method for adding new finance user
	 * 
	 * @param newFinanceUser
	 * @return String
	 */
	String addFinanceUser(FinanceUser newFinanceUser);

	/**
	 * method for updating user password
	 * 
	 * @param financeUserId
	 * @param oldPassword
	 * @param newPassword
	 * @return FinanceUser
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	FinanceUser changeFinanceUserPassword(String financeUserId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException;

	/**
	 * method for updating user mobile
	 * 
	 * @param financeUserId
	 * @param newMobile
	 * @return
	 */
	int changeFinanceUserMobile(String financeUserId, String newMobile);
	
	/**
	 * method for updating user email
	 * 
	 * @param financeUserId
	 * @param newEMail
	 * @return
	 */
	int changeFinanceUserEMail(String financeUserId, String newEMail);
	
	/**
	 * method for fetching all finance user ids
	 * 
	 * @return List<String>
	 */
	List<String> getAllUserIds();

	/**
	 * method for fetching the list of applied claims
	 * 
	 * @return List<ExpenseClaim>
	 */
	List<ExpenseClaim> getAllClaims();

	/**
	 * method for updating claim status to approved
	 * 
	 * @param claimId
	 * @return int
	 */
	int approveClaim(int claimId);

	/**
	 * method for updating claim status to rejected
	 * 
	 * @param claimId
	 * @return int
	 */
	int rejectClaim(int claimId);

}
