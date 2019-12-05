package com.ysd.humanresource.entity;

import java.util.List;

import lombok.Data;

@Data
public class Pagination<T> {
	
	Integer page;
	Integer pageSize;
	Integer total;
	List<T> rows;
	
	// 薪酬标准复核查询条件
	private String ss_name;
	private String ss_enactingPerson;
	private String ss_registrant;
	private String ss_registrationTimeStart;
	private String ss_registrationTimeEnd;
	//试题查询条件
	private String department;
	private String position;
	
}
