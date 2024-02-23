package com.hglobal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hglobal.demo.result.Result;
import com.hglobal.demo.service.EmployeeService;


@RestController
public class Controller {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employee-email-id-exists")
	public Result getEmployeeemailIdExists(@RequestParam("emailID") String emailID)    {
		return service.getEmployeeByEmailID(emailID);
	}
}
