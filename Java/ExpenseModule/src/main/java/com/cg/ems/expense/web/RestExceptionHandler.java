package com.cg.ems.expense.web;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ems.expense.exception.WrongIDException;
import com.cg.ems.expense.exception.WrongValidationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(WrongIDException.class)
	@ResponseBody
	public ResponseEntity<Object> handleWrongID(WrongIDException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(WrongValidationException.class)
	@ResponseBody
	public ResponseEntity<Object> handleWrongValidation(WrongValidationException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<Object> handleWrongVaslidation(ConstraintViolationException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(WrongNameException.class)
//	@ResponseBody
//	public ResponseEntity<Object> handleWrongName(WrongNameException ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	}
//	@ExceptionHandler(WrongIDException.class)
//	public void handleInvalidMovie(HttpServletResponse response) throws IOException {
//		response.sendError(HttpStatus.NOT_FOUND.value());
//	}
	
//	@ExceptionHandler(WrongNameException.class)
//	public void handleWrongName(HttpServletResponse response) throws IOException {
//		response.sendError(HttpStatus.NOT_FOUND.value());
//	}
}