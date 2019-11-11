package com.cg.ems.expenseclaim.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.expenseclaim.dao.ExpenseClaimDao;
import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

/**
 * ExpenseClaimServiceimpl class - Contains business logic of the various CRUD operations.
 * Delegates call to ExpenseClaimDao where the CRUD operations get implemented.
 * @author Pritam Kumar Roy
 * @version 1.0
 */
@Service
@Transactional
public class ExpenseClaimServiceImpl implements ExpenseClaimService {
	
	//Autowiring ExpenseClaimDao object
	@Autowired
	private ExpenseClaimDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseClaimServiceImpl.class);
	
	/**
	 * Function to add expenseClaim in database - after employee logins.
	 * Delegates the call to ExpenseClaimDao where the query gets fired to add the claim details to database.
	 * @param claim
	 * @return Integer
	 */
	
	@Override
	public int addClaim(ExpenseClaim claim) {
		logger.info("In addClaim method of service");
			return dao.save(claim).getClaimId();
	}
	
	/**
	 * Function to search claim by id from the database-
	 * delegate the call to ExpenseClaimDao where search takes place by claimId
	 * @param claimId
	 * @return
	 * @throws ExpenseClaimNotFound
	 */
	@Override
	public ExpenseClaim viewClaim(int claimId)throws ExpenseClaimNotFound {
		logger.info("In viewClaim method of service");
		ExpenseClaim claim=dao.findById(claimId).get();
		if(claim==null) {
			logger.error("Object not retrieved from repo. ExpenseClaim not found");
			throw new ExpenseClaimNotFound("ExpenseClaim with id "+claimId+" not found");
		}else {
			logger.info("object retrieved from repo. ExpenseClaim found.");
		return claim;
	}
		}
	
	/**
	 * Function to modifyClaim by id from the database-
	 * delegate the call to ExpenseClaim where modification takes place by claimId
	 * @param claim
	 * @return
	 */
	@Override
	public ExpenseClaim modifyClaim(ExpenseClaim claim) throws ExpenseClaimNotFound{
		logger.info("In modifyClaim method of service");
		Optional<ExpenseClaim> retrivedClaim=dao.findById(claim.getClaimId());
		if(retrivedClaim==null) {
			logger.error("Object not retrieved from repo. ExpenseClaim not found");
			throw new ExpenseClaimNotFound("ExpenseClaim with id "+claim.getClaimId()+" not found");
		}else {
			logger.info("object retrieved from repo. ExpenseClaim found.");
		return dao.save(claim);
		}
	}
	
	/**
	 * Function to deleteClaim by id from the database-
	 * delegate the call to ExpenseClaimDao where delete takes place by claimId
	 * @param claimId
	 * @return
	 */
	@Override
	public boolean deleteClaim(int claimId) throws ExpenseClaimNotFound {
		logger.info("In deleteClaim method of service");
		Optional<ExpenseClaim> retrivedClaim=dao.findById(claimId);
		if(retrivedClaim==null) {
			logger.error("Object not retrieved from repo. ExpenseClaim not found");
			throw new ExpenseClaimNotFound("ExpenseClaim with id "+claimId+" not found");
		}
		else {
			logger.info("object retrieved from repo. ExpenseClaim found.");
		 dao.deleteById(claimId);
		 return true;
		}
	}

	@Override
	public List<ExpenseClaim> getAllClaims() {
		return dao.findAll();
	}

}
