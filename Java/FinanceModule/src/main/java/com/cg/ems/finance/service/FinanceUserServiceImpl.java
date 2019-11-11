/**
 * Service layer class implementing service interface containing business logic
 * and for communicating between DAO layer and Controller layer
 */
package com.cg.ems.finance.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;
import com.cg.ems.finance.repo.FinanceUserRepo;

/**
 * @author Panja
 * @version 1.0
 */

@Service
@Transactional(rollbackFor = InvalidFinanceUserLoginCredentialsException.class)
public class FinanceUserServiceImpl implements FinanceUserService {

	static Logger financeUserServiceLogger;

	static {
		financeUserServiceLogger = Logger.getLogger(FinanceUserServiceImpl.class);
	}

	/**
	 * for creating financeUserRepo object everytime FinanceUserServiceImpl is
	 * created
	 */
	@Autowired
	private FinanceUserRepo financeUserRepo;

	/**
	 * overridden method of service interface for validating login id and password
	 */
	@Override
	public FinanceUser authenticateFinanceUser(String loginId, String loginPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser loggedInUser = financeUserRepo.validateLoginId(loginId);
		if (loggedInUser != null) {
			loggedInUser = financeUserRepo.validateLoginPassword(loginId, loginPassword);
			if (loggedInUser != null) {
				financeUserServiceLogger.info("user logged in with user id: " + loggedInUser.getFinanceUserId());
				return loggedInUser;
			} else {
				financeUserServiceLogger
						.error("InvalidFinanceUserLoginCredentialsException thrown because Invalid password provided.");
				throw new InvalidFinanceUserLoginCredentialsException("Invalid login password!");
			}
		} else {
			financeUserServiceLogger
					.error("InvalidFinanceUserLoginCredentialsException thrown because Invalid login id provided.");
			throw new InvalidFinanceUserLoginCredentialsException("Invalid login ID!");
		}
	}

	/**
	 * overridden method of service interface for adding new finance user
	 */
	@Override
	public String addFinanceUser(FinanceUser newFinanceUser) {
		financeUserRepo.save(newFinanceUser);
		financeUserServiceLogger.info("user registered with user id: " + newFinanceUser.getFinanceUserId());
		return newFinanceUser.getFinanceUserId();
	}

	/**
	 * overridden method of service interface for updating user password
	 */
	@Override
	public FinanceUser changeFinanceUserPassword(String financeUserId, String oldPassword, String newPassword)
			throws InvalidFinanceUserLoginCredentialsException {
		int i = financeUserRepo.updateFinanceUserPassword(financeUserId, oldPassword, newPassword);
		if (i != 0) {
			financeUserServiceLogger.info("Password changed successfully for user id: " + financeUserId);
			return financeUserRepo.validateLoginId(financeUserId);
		} else {
			financeUserServiceLogger.error(
					"InvalidFinanceUserLoginCredentialsException thrown. Password change unsuccessful because invalid login credentials provided");
			throw new InvalidFinanceUserLoginCredentialsException("Invalid credentials!");
		}
	}

	/**
	 * overridden method of service interface for updating user mobile
	 */
	@Override
	public int changeFinanceUserMobile(String financeUserId, String newMobile) {
		financeUserServiceLogger.info("Mobile no. changed successfully for user id: " + financeUserId);
		return financeUserRepo.updateFinanceUserMobile(financeUserId, newMobile);
	}

	/**
	 * overridden method of service interface for updating user email
	 */
	@Override
	public int changeFinanceUserEMail(String financeUserId, String newEMail) {
		financeUserServiceLogger.info("E-mail id changed successfully for user id: " + financeUserId);
		return financeUserRepo.updateFinanceUserEMail(financeUserId, newEMail);
	}

	/**
	 * overridden method of service interface for fetching all finance user ids
	 */
	@Override
	public List<String> getAllUserIds() {
		financeUserServiceLogger.info("List of all finance user ids fetched");
		return financeUserRepo.getAllUserIds();
	}

	/**
	 * overridden method of service interface for fetching the list of applied
	 * claims
	 */
	@Override
	public List<ExpenseClaim> getAllClaims() {
		financeUserServiceLogger.info("List of all claims fetched");
		return financeUserRepo.getAllClaims();
	}

	/**
	 * overridden method of service interface for updating claim status to approved
	 */
	@Override
	public int approveClaim(int claimId) {
		String status = "Approved";
		financeUserServiceLogger.info("Claim approved successfully for claim id: " + claimId);
		return financeUserRepo.updateClaim(status, claimId);
	}

	/**
	 * overridden method of service interface for updating claim status to rejected
	 */
	@Override
	public int rejectClaim(int claimId) {
		String status = "Rejected";
		financeUserServiceLogger.info("Claim rejected successfully for claim id: " + claimId);
		return financeUserRepo.updateClaim(status, claimId);
	}

}
