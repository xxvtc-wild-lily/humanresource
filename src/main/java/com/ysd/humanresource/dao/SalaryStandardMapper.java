package com.ysd.humanresource.dao;

import com.ysd.humanresource.entity.SalaryStandard;

public interface SalaryStandardMapper {
	
	/**
	 * 添加薪酬标准
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 受影响的行数
	 */
	Integer insertSalaryStandard(SalaryStandard salaryStandard);
	
}
