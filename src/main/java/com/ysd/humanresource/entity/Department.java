package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Department {
	
	private Integer Dep_id;
	private String Dep_name;
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date Dep_lastPayday;
	private Integer Dep_salaryStatus;
	
}
