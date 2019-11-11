/**
 * repository interface containing methods for interacting with the database
 */
package com.cg.ems.finance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;

/**
 * @author Panja
 * @version 1.0
 */

@Repository
public interface FinanceUserRepo extends JpaRepository<FinanceUser, String> {

	/**
	 * method with custom query for validating loginid
	 * @param loginid
	 * @return FinanceUser
	 */
	@Query("SELECT f FROM FinanceUser f WHERE f.financeUserId=:loginid")
	FinanceUser validateLoginId(String loginid);

	/**
	 * method with custom query for validating login password with login id
	 * @param loginid
	 * @param loginpassword
	 * @return FinanceUser
	 */
	@Query("SELECT f FROM FinanceUser f WHERE f.financeUserId=:loginid AND f.financeUserPassword=:loginpassword")
	FinanceUser validateLoginPassword(String loginid, String loginpassword);

	/**
	 * method with custom query for updating user password
	 * @param financeUserId
	 * @param oldPassword
	 * @param newPassword
	 * @return int
	 */
	@Modifying
	@Query("UPDATE FinanceUser f SET f.financeUserPassword=:newPassword WHERE f.financeUserId=:financeUserId AND f.financeUserPassword=:oldPassword")
	int updateFinanceUserPassword(String financeUserId, String oldPassword, String newPassword);

	/**
	 * method with custom query for updating user mobile
	 * @param financeUserId
	 * @param newMobile
	 * @return int
	 */
	@Modifying
	@Query("UPDATE FinanceUser f SET f.financeUserMobile=:newMobile WHERE f.financeUserId=:financeUserId")
	int updateFinanceUserMobile(String financeUserId, String newMobile);

	/**
	 * method with custom query for updating user email
	 * @param financeUserId
	 * @param newEMail
	 * @return int
	 */
	@Modifying
	@Query("UPDATE FinanceUser f SET f.financeUserEMail=:newEMail WHERE f.financeUserId=:financeUserId")
	int updateFinanceUserEMail(String financeUserId, String newEMail);

	/**
	 * method with custom query for fetching all finance user ids
	 * @return List string
	 */
	@Query("SELECT financeUserId FROM FinanceUser f")
	List<String> getAllUserIds();

	/**
	 * method with custom query for fetching the list of applied claims
	 * @return List of expense claims
	 */
	@Query("SELECT c FROM ExpenseClaim c")
	List<ExpenseClaim> getAllClaims();

	/**
	 * method with custom query for updating claim status
	 * @param status
	 * @param claimId
	 * @return int
	 */
	@Modifying
	@Query("UPDATE ExpenseClaim c SET c.status=:status WHERE c.claimId=:claimId")
	int updateClaim(String status, int claimId);
}
