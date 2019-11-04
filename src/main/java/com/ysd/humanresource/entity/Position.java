package com.ysd.humanresource.entity;

import lombok.Data;

@Data
//职位表
public class Position {
	private Integer pos_id;	//职位id
	private Integer dep_id;	//部门id
	private Integer ss_id;	//薪酬标准id
	private Integer pos_name;	//职位名称

}
