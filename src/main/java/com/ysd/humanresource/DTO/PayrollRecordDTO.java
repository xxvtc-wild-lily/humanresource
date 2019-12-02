package com.ysd.humanresource.DTO;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PayrollRecordDTO {
	
	private String pr_paySlipNumber;
	private String emp_fileNumber;
	private String emp_name;
	private String pr_registrant;
	private Date pr_registrationTime;
	private BigDecimal ss_baseSalary;
	private BigDecimal ss_trafficSubsidy;
	private BigDecimal ss_communicationSubsidy;
	private BigDecimal ss_floatWages;
	private BigDecimal ss_routine;
	private BigDecimal ss_lunchAllowance;
	private BigDecimal ss_vehicleSubsidy;
	private BigDecimal pr_rewardAmount;
	private BigDecimal pr_amountPayable;
	private String pr_payrollRemarks;
	private String pr_ext1;
	private Integer pr_ext2;
	
}
