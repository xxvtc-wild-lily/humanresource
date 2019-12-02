package com.ysd.humanresource.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Department {
	
	private Integer dep_id;
	private String dep_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dep_lastPayday;
	private Integer dep_salaryStatus;
	private Position position;
}
