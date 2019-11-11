/**
 * class containing test methods for service layer methods
 */
package com.cg.ems.finance.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.finance.dto.ExpenseClaim;
import com.cg.ems.finance.dto.FinanceUser;
import com.cg.ems.finance.exception.InvalidFinanceUserLoginCredentialsException;

/**
 * @author Panja
 * @version 1.0
 */
@RunWith(SpringRunner.class)

@SpringBootTest
public class FinanceUserServiceImplTest {

	@Autowired
	private FinanceUserService service;

	private FinanceUser user;

	private ExpenseClaim claim;

//	@BeforeClass
//	public void initClass() {
//		user = new FinanceUser();
//		user.setFinanceUserId("FE11111");
//		user.setFinanceUserName("Panja");
//		user.setFinanceUserPassword("Passw12");
//		user.setFinanceUserMobile("9879879877");
//		user.setFinanceUserEMail("panja@mail.com");
//
//	}
	
	/**
	 * this function is executed before every test case
	 */
	@Before
	public void init() {
		user = new FinanceUser();
		user.setFinanceUserId("FE12345");
		user.setFinanceUserName("Panja");
		user.setFinanceUserPassword("Passw12");
		user.setFinanceUserMobile("9879879877");
		user.setFinanceUserEMail("panja@mail.com");

	}

	/**
	 * test case for authenticating login
	 */
	@Test
	public void testAuthenticateLogin() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.authenticateFinanceUser("FE11111", "Passw12");
		assertNotNull(testUser);
	}

	/**
	 * test case for login authentication fail
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	@Test(expected = InvalidFinanceUserLoginCredentialsException.class)
	public void testFailAuthenticateLogin() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.authenticateFinanceUser("FE11112", "Passw12");
		assertNotNull(testUser);
	}

	/**
	 * test case for registering new user
	 */
	@Test
	public void testRegister() {
		String testUser = service.addFinanceUser(user);
		assertTrue(testUser.equals(user.getFinanceUserId()));
	}

	/**
	 * test case for new user registration fail
	 */
	@Test
	public void testFailRegister() {
		String testUser = service.addFinanceUser(user);
		assertFalse(testUser.equals("FE123456"));
	}

	/**
	 * test case for changing password of registered user
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	@Test
	public void testChangeFinanceUserPassword() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.changeFinanceUserPassword("FE11111", "Passw12", "Passw23");
		assertTrue(testUser.getFinanceUserPassword().equals("Passw23"));
	}

	/**
	 * test case for failing change password of registered user
	 * @throws InvalidFinanceUserLoginCredentialsException
	 */
	@Test(expected = InvalidFinanceUserLoginCredentialsException.class)
	public void testFailChangeFinanceUserPassword() throws InvalidFinanceUserLoginCredentialsException {
		FinanceUser testUser = service.changeFinanceUserPassword("FE11111", "Passw2", "Passw23");
		assertFalse(testUser.getFinanceUserPassword().equals("Passw23"));
	}
	
	/**
	 * test case for changing finance user mobile
	 */
	@Test
	public void testChangeFinanceMobile(){
		int testint = service.changeFinanceUserMobile("FE11111", "9879879254");
		assertEquals(testint, 1);
	}
	
	/**
	 * test case for failing change finance user mobile
	 */
	@Test
	public void testFailChangeFinanceMobile(){
		int testint = service.changeFinanceUserMobile("FEXYZ110", "9879879254");
		assertEquals(testint, 0);
	}
	
	/**
	 * test case for changing finance user email
	 */
	@Test
	public void testChangeFinanceEmail(){
		int testint = service.changeFinanceUserEMail("FE11111", "panja@mail.com");
		assertEquals(testint, 1);
	}
	
	/**
	 * test case for failing change finance user email
	 */
	@Test
	public void testFailChangeFinanceEmail(){
		int testint = service.changeFinanceUserEMail("FEXYZ110", "panja@mail.com");
		assertEquals(testint, 0);
	}

	/**
	 * test case for fetching list of all user ids
	 */
	@Test
	public void testGetAllUserIds() {
		List<String> list = service.getAllUserIds();
		assertNotNull(list);
	}

	/**
	 * test case for fetching list of all claims
	 */
	@Test
	public void testGetAllClaims() {
		List<ExpenseClaim> list = service.getAllClaims();
		assertNotNull(list);
	}

	/**
	 * test case for approving applied claim
	 */
	@Test
	public void testApproveClaim() {
		assertEquals(1, service.approveClaim(50001));
	}

	/**
	 * test case for rejecting applied claim
	 */
	@Test
	public void testRejectClaim() {
		assertEquals(1, service.rejectClaim(50002));
	}

}
