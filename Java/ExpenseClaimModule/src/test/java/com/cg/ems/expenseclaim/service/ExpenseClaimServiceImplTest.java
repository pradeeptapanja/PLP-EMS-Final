package com.cg.ems.expenseclaim.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseClaimServiceImplTest {
	
	@Autowired
	private ExpenseClaimService service;
	
	ExpenseClaim claim;
	
	@Before
	public void init() {
		claim=new ExpenseClaim();
	}

	@After
	public void tearDown() {
		claim=null;
	}

	@Test
	public void testAddClaim() {//successful
		claim.setEmployeeId("EE46005");
		claim.setProjectId(1);
		claim.setClientId(301);
		claim.setExpenseId(1);
		claim.setFinanceUserId("FE10000");
		claim.setAmount(5000);
		claim.setStartDate(Date.valueOf(LocalDate.parse("1997-12-19")));
		claim.setStatus("Applied");
		claim.setDescription("Must Be atleast 10 characters");
		int exp=service.addClaim(claim);
	}
	
	@Test
	public void testAddClaimFailure() {//violation
		//claim.setEmployeeId("EE46005");
		claim.setProjectId(1);
		claim.setClientId(301);
		claim.setExpenseId(1);
		claim.setFinanceUserId("FE10000");
		claim.setAmount(5000);
		claim.setStartDate(Date.valueOf(LocalDate.parse("1997-12-19")));
		claim.setStatus("Applied");
		claim.setDescription("Must Be atleast 10 characters");
		int exp=service.addClaim(claim);
	}
	
	@Test
	public void testViewClaim() throws ExpenseClaimNotFound {//success
		assertNotNull(service.viewClaim(7));
	}
	
	@Test
	public void testViewClaimFailure() throws ExpenseClaimNotFound {//failure
		assertNotNull(service.viewClaim(10));
	}


	@Test
	public void testDeleteClaim() throws ExpenseClaimNotFound {//successful
		assertTrue(service.deleteClaim(7));
	}
	

	@Test
	public void testDeleteClaimFailure() throws ExpenseClaimNotFound {//failure
		assertTrue(service.deleteClaim(8));
	}
	
	@Test(expected = ExpenseClaimNotFound.class)
	public void testFailRetriveClaim() throws ExpenseClaimNotFound {//success
		ExpenseClaim exp=(service.viewClaim(7));
	}
	@Test(expected = ExpenseClaimNotFound.class)
	public void testFailRetriveClaimFailure() throws ExpenseClaimNotFound {//failure
		ExpenseClaim exp=(service.viewClaim(3));
	}
}
