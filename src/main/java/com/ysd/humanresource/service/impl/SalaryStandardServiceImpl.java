package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.SalaryStandardMapper;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.enums.SalaryStandardStatusEnum;
import com.ysd.humanresource.service.SalaryStandardService;
import com.ysd.humanresource.util.MoneyJudgeUtil;

@Service
public class SalaryStandardServiceImpl implements SalaryStandardService {
	
	@Autowired
	private SalaryStandardMapper salaryStandardMapper;

	@Override
	public Integer insertSalaryStandard(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		
		salaryStandard.setSs_aduitStatus(SalaryStandardStatusEnum.SALARYSTANDARDWAITADUIT.getCode());
		salaryStandard.setSs_baseSalary(MoneyJudgeUtil.judge(salaryStandard.getSs_baseSalary()));
		salaryStandard.setSs_trafficSubsidy(MoneyJudgeUtil.judge(salaryStandard.getSs_trafficSubsidy()));
		salaryStandard.setSs_communicationSubsidy(MoneyJudgeUtil.judge(salaryStandard.getSs_communicationSubsidy()));
		salaryStandard.setSs_floatWages(MoneyJudgeUtil.judge(salaryStandard.getSs_floatWages()));
		salaryStandard.setSs_routine(MoneyJudgeUtil.judge(salaryStandard.getSs_routine()));
		salaryStandard.setSs_lunchAllowance(MoneyJudgeUtil.judge(salaryStandard.getSs_lunchAllowance()));
		salaryStandard.setSs_vehicleSubsidy(MoneyJudgeUtil.judge(salaryStandard.getSs_vehicleSubsidy()));
		
		return salaryStandardMapper.insertSalaryStandard(salaryStandard);
	}
	
	@Override
	public Integer selectCountBySalaryStandardName(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		return salaryStandardMapper.selectCountBySalaryStandardName(salaryStandard);
	}

	@Override
	public List<SalaryStandard> selectAllUncheckSalaryStandard(Pagination pagination) {
		// TODO Auto-generated method stub
		return salaryStandardMapper.selectAllUncheckSalaryStandard(pagination);
	}
	
	@Override
	public Integer selectCountBySalaryStandardNameAndId(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		return salaryStandardMapper.selectCountBySalaryStandardNameAndId(salaryStandard);
	}

	@Override
	public Integer updateSalaryStandardById(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		salaryStandard.setSs_aduitStatus(SalaryStandardStatusEnum.SALARYSTANDARDPASSEDADUIT.getCode());
		return salaryStandardMapper.updateSalaryStandardById(salaryStandard);
	}
	
}
