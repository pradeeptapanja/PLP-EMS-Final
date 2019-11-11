/**
 * user defined exception class
 */
package com.cg.ems.finance.exception;

/**
 * @author Panja
 * @version 1.0
 */
public class InvalidFinanceUserLoginCredentialsException extends Exception {

	private String uriDetails;

	public String getUriDetails() {
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}

	/**
	 * Default constructor of InvalidFinanceUserLoginCredentialsException class
	 */
	public InvalidFinanceUserLoginCredentialsException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public InvalidFinanceUserLoginCredentialsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public InvalidFinanceUserLoginCredentialsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public InvalidFinanceUserLoginCredentialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public InvalidFinanceUserLoginCredentialsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
