package com.ysd.humanresource.entity;

import java.util.List;

import lombok.Data;

@Data
public class Position {
	private Integer pos_id;
	private Integer dep_id;
	private Integer ss_id;
	private String pos_name;
	private Department department;
	private SalaryStandard salaryStandard;
	private List<Employee> employeeList;
	
}
