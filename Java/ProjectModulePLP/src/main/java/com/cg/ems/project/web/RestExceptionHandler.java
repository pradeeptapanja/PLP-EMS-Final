package com.cg.ems.project.web;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ems.project.exception.WrongDurationException;
import com.cg.ems.project.exception.WrongIDException;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(WrongIDException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidSomething(WrongIDException ex){
		System.out.println("Exception : "+ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(WrongDurationException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidSomething2o(WrongDurationException ex){
		System.out.println("Exception : "+ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
