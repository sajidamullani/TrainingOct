package com.mastek.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mastek.exception.EmptyInputException;
import com.mastek.exception.NoSuchElementException;

@ControllerAdvice
public class GlobalException {


	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> noInputException(EmptyInputException emp){
		return new ResponseEntity<String>("No Input given",HttpStatus.BAD_REQUEST);
		
	}
	/*@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementInputException(NoSuchElementException e){
		return new ResponseEntity<String>("No element found",HttpStatus.BAD_REQUEST);
		
	}*/

}
