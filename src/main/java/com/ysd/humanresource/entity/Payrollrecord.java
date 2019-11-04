package com.ysd.humanresource.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//发薪记录表
public class Payrollrecord {
	private Integer pr_id;	//发薪记录id
	private String pr_paySlipNumber;	//薪酬单编号
	private String pr_fileNumber;	//档案编号
	private String emp_name;	//员工姓名
	private String pr_registrant;	//登记人
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date pr_registrationTime;	//登记时间
	private BigDecimal pr_baseSalary;	//基本薪酬
	private BigDecimal pr_trafficSubsidy;	//交通补贴
	private BigDecimal pr_communicationSubsidy;	//通讯补贴
	private BigDecimal pr_floatingWages;	//浮动工资
	private BigDecimal pr_routine;	//常规
	private BigDecimal pr_lunchAllowance;	//午餐补助
	private BigDecimal pr_vehicleSubsidy;	//车补
	private BigDecimal pr_rewardAmount;	//奖励金额
	private BigDecimal pr_amountPayable;	//应扣金额
	private String pr_payrollRemarks;	//发薪备注

}
