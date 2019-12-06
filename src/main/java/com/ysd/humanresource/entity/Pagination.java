package com.ysd.humanresource.entity;

import java.util.List;

import lombok.Data;

@Data
public class Pagination<T> {
	
	Integer page;
	Integer pageSize;
	Integer total;
	List<T> rows;
	
	// 薪酬管理
	private String ss_name;
	private String ss_enactingPerson;
	private String ss_registrant;
	private String ss_reviewer;
	private String ss_registrationTimeStart;
	private String ss_registrationTimeEnd;
	private String ss_reviewTimeStart;
	private String ss_reviewTimeEnd;
	private String emp_name;
	private String pr_registrant;
	private String pr_registrationTimeStart;
	private String pr_registrationTimeEnd;
	
	// 角色管理
	private String r_name;
	
	// 员工管理
	private Integer emp_sex;
	private Integer emp_ageStart;
	private Integer emp_ageEnd;
	private String emp_birthdayStart;
	private String emp_birthdayEnd;
	private Integer pos_id;
	
}
