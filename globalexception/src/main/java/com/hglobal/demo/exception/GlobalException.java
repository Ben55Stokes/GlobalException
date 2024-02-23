package com.hglobal.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hglobal.demo.utility.RequiredConstants;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoParameterException.class)
	public ResponseEntity<String> noParameterException(NoParameterException noParameterException){
		return new ResponseEntity<String>(RequiredConstants.NOPARAMETERFOUND, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoDataFound.class)
	public ResponseEntity<String> noParameterException(NoDataFound noDataFound){
		return new ResponseEntity<String>(RequiredConstants.empty, HttpStatus.NOT_FOUND);
	}
}
