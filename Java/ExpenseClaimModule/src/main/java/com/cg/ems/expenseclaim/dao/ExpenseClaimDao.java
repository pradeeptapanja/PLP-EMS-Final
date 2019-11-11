package com.cg.ems.expenseclaim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;

/**
 * ExpenseClaimDao interface - extends JpaRepository.
 * @author Pritam Kumar Roy
 * @version 1.0
 *
 */
public interface ExpenseClaimDao extends JpaRepository<ExpenseClaim, Integer>{
	

}
