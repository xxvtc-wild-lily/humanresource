package com.ysd.humanresource.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class SalaryStandard {
	
	private Integer ss_id;
	private String ss_name;
	private String ss_enactingPerson;
	private String ss_registrant;
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date ss_registrationTime;
	private String ss_reviewer;
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date ss_reviewTime;
	private Integer ss_aduitStatus;
	private String ss_aduitOpinion;
	private BigDecimal ss_baseSalary;
	private BigDecimal ss_trafficSubsidy;
	private BigDecimal ss_communicationSubsidy;
	private BigDecimal ss_floatWages;
	private BigDecimal ss_routine;
	private BigDecimal ss_lunchAllowance;
	private BigDecimal ss_vehicleSubsidy;
	
}
