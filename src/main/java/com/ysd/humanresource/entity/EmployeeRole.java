package com.ysd.humanresource.entity;

import lombok.Data;

@Data
//员工角色中间表
public class EmployeeRole {
	private Integer er_id;	//员工角色id
	private Integer emp_id;	//员工id
	private Integer r_id;	//角色id

}
