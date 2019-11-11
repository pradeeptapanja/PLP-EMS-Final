package com.cg.ems.expenseclaim.service;

import java.util.List;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

public interface ExpenseClaimService {
	
	int addClaim(ExpenseClaim claim);
	
	ExpenseClaim viewClaim(int claimId) throws ExpenseClaimNotFound;
		
	boolean deleteClaim(int claimId) throws ExpenseClaimNotFound;

	ExpenseClaim modifyClaim(ExpenseClaim claim) throws ExpenseClaimNotFound;

	List<ExpenseClaim> getAllClaims();
	
	

}
