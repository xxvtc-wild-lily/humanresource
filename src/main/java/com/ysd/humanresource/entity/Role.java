package com.ysd.humanresource.entity;

import lombok.Data;

@Data
public class Role {
	
	private Integer r_id;
	private String r_name;
	
	private Module module;
	
}
