package com.mastek.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.String;
@Repository
@Component
public class BusinessException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	
	public BusinessException(String errorCode, String errorMessage) {
	
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
	return errorCode;
	}
	public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
	}
	public String getErrorMessage() {
	return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
	return serialVersionUID;
	}
	
	public BusinessException() {

	}

		
	

}
