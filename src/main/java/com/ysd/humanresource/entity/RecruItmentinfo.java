package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//招聘信息表
public class RecruItmentinfo {
	private Integer ri_id;	//招聘信息id
	private String ri_recruitmentType;	//招聘类型
	private String ri_department;	//招聘部门
	private String ri_positon;	//招聘职位
	private Integer ri_recruitingNumber;	//招聘人数
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_closingDate;	//截止日期
	private String ri_registrant;	//登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_registrationTime;	//登记时间
	private String ri_alteredPerson;	//变更人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ri_changeTime;	//变更时间
	private String ri_jobDescription;	//职位描述
	private String ri_recruitmentRequirements;	//招聘要求

}
