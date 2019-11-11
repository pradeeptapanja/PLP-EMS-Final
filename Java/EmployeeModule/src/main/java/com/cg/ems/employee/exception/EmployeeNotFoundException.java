package com.cg.ems.employee.exception;

/**
 * Custom Exception - EmployeeNotFoundException
 * @author Vivek Bothra
 * @version 1.0
 *
 */
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmployeeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmployeeNotFoundException(String arg0) {
		super(arg0);
	}

	public EmployeeNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
