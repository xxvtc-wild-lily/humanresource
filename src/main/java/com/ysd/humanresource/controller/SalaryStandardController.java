package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.service.SalaryStandardService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryStandardController {
	
	@Autowired
	private SalaryStandardService salaryStandardService;
	
	@PostMapping("/submitSalaryStandard")
	public Integer submitSalaryStandard(SalaryStandard salaryStandard) {
		return salaryStandardService.insertSalaryStandard(salaryStandard);
	}
	
}
