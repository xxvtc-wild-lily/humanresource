package com.ysd.humanresource.service;

import com.ysd.humanresource.entity.SalaryStandard;

public interface SalaryStandardService {
	
	/**
	 * 添加薪酬标准
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 受影响的行数
	 */
	Integer insertSalaryStandard(SalaryStandard salaryStandard);
	
}
