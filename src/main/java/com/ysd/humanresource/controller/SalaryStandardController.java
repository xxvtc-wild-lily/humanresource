package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.service.SalaryStandardService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryStandardController {
	
	@Autowired
	private SalaryStandardService salaryStandardService;
	
	@PostMapping("/submitSalaryStandard")
	public Integer submitSalaryStandard(SalaryStandard salaryStandard) {
		return salaryStandardService.insertSalaryStandard(salaryStandard);
	}
	
	@PostMapping("/isSalaryStandardNameExists")
	public Integer isSalaryStandardNameExists(SalaryStandard salaryStandard) {
		return salaryStandardService.selectCountBySalaryStandardName(salaryStandard);
	}
	
	@PostMapping("/getUncheckSalaryStandard")
	public Pagination<SalaryStandard> getUncheckSalaryStandard(Integer page,@RequestParam("rows") Integer pageSize,Pagination<SalaryStandard> pagination) {
		pagination.setPage((page - 1) * pageSize);
		pagination.setPageSize(pageSize);
		return salaryStandardService.selectAllUncheckSalaryStandard(pagination);
	}
	
	@PostMapping("/isSalaryStandardNameAndIdExists")
	public Integer isSalaryStandardNameAndIdExists(SalaryStandard salaryStandard) {
		return salaryStandardService.selectCountBySalaryStandardNameAndId(salaryStandard);
	}
	
	@PostMapping("/submitExaminedSalaryStandard")
	public Integer submitExaminedSalaryStandard(SalaryStandard salaryStandard) {
		return salaryStandardService.updateSalaryStandardById(salaryStandard);
	}
	
	@PostMapping("/getAllcheckedSalaryStandard")
	public Pagination<SalaryStandard> getAllcheckedSalaryStandard(Integer page,@RequestParam("rows") Integer pageSize,Pagination<SalaryStandard> pagination) {
		pagination.setPage((page - 1) * pageSize);
		pagination.setPageSize(pageSize);
		return salaryStandardService.selectAllCheckedSalaryStandard(pagination);
	}
	
}
