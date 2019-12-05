package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class RecruItmentinfo {
	
	private Integer ri_id;
	private String ri_recruitmentType;
	private String ri_department;
	private String ri_position;
	private Integer ri_recruitingNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_closingDate;
	private String ri_registrant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_registrationTime;
	private String ri_alteredPerson;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_changeTime;
	private String ri_jobDescription;
	private String ri_recruitmentRequirements;
	
}
