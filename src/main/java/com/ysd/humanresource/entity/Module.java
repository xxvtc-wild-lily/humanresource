package com.ysd.humanresource.entity;

import lombok.Data;

@Data
public class Module {
	
	private Integer m_id;
	private String m_name;
	private Integer m_parentId;
	private String m_path;
	private Integer m_weight;
	
}
