package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//部门表
public class Department {
	private Integer Dep_id;	//部门id
	private String Dep_name;	//部门名称
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date Dep_lastPayday;	//部门上次发薪时间
	private Integer Dep_salaryStatus;	//部门发薪状态

}
