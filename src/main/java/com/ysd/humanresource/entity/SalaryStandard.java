package com.ysd.humanresource.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//薪酬标准表
public class SalaryStandard {
	private Integer ss_id;	//薪酬id
	private String ss_name;	//薪酬标准名称
	private String ss_enactingPerson;	//制定人
	private String ss_registrant;	//登记人
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date ss_registrationTime;	//登记时间
	private String ss_reviewer;	//复核人
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date ss_reviewTime;	//复核时间
	private Integer ss_auditStatus;	//审核状态
	private String ss_auditOpinion;	//审核意见
	private BigDecimal ss_baseSalary;	//基本薪酬
	private BigDecimal ss_trafficSubsidy;	//交通补贴
	private BigDecimal ss_communicationSubsidy;	//通讯补贴
	private BigDecimal ss_floatingWages;	//浮动工资
	private BigDecimal ss_routine;	//常规
	private BigDecimal ss_lunchAllowance;	//午餐补助
	private BigDecimal ss_vehicleSubsidy;	//车补

}
