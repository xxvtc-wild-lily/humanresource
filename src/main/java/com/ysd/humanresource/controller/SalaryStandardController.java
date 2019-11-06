package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.humanresource.service.SalaryStandardService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryStandardController {
	
	@Autowired
	private SalaryStandardService salaryStandardService;
	
}
