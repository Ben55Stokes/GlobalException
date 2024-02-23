package com.hglobal.demo.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hglobal.demo.entity.EmployeeEntity;
import com.hglobal.demo.exception.NoDataFound;
import com.hglobal.demo.exception.NoParameterException;
import com.hglobal.demo.repository.EmployeeRepository;
import com.hglobal.demo.result.Result;
import com.hglobal.demo.utility.RequiredConstants;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class EmployeeService implements com.hglobal.demo.service.EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Result getEmployeeByEmailID(String emailID) {
		if(emailID==null) {
			throw new NoParameterException(HttpStatus.BAD_REQUEST.value(), RequiredConstants.NOPARAMETERFOUND);
		}
		Optional<EmployeeEntity> employeeEntity = null;
		Result result = null;
		log.info("inside getEmployeeByEmailID before hitting db");
		employeeEntity = employeeRepository.findEmployeeByEmailID(emailID);
		if(employeeEntity.isEmpty()) {
			throw new NoDataFound(HttpStatus.NOT_FOUND.value(), RequiredConstants.empty);
		}else {
			result=new Result();
			result.setData(employeeEntity.get());
			result.setStatusCode(HttpStatus.OK.value());
		}
		log.info("inside getEmployeeByEmailID after hitting db");
		return result;
	}

}
