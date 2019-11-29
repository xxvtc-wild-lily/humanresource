package com.ysd.humanresource.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class PayrollRecord {
	
	private Integer pr_id;
	private String pr_paySlipNumber;
	private String pr_fileNumber;
	private String emp_name;
	private String pr_registrant;
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date pr_registrationTime;
	private BigDecimal pr_baseSalary;
	private BigDecimal pr_trafficSubsidy;
	private BigDecimal pr_communicationSubsidy;
	private BigDecimal pr_floatWages;
	private BigDecimal pr_routine;
	private BigDecimal pr_lunchAllowance;
	private BigDecimal pr_vehicleSubsidy;
	private BigDecimal pr_rewardAmount;
	private BigDecimal pr_amountPayable;
	private String pr_payrollRemarks;
	private String pr_ext1;
	private Integer pr_ext2;
	
}
