package com.ysd.humanresource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.SalaryStandardMapper;
import com.ysd.humanresource.service.SalaryStandardService;

@Service
public class SalaryStandardServiceImpl implements SalaryStandardService {
	
	@Autowired
	private SalaryStandardMapper salaryStandardMapper;
	
}
