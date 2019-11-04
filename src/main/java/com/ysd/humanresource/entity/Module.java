package com.ysd.humanresource.entity;

import lombok.Data;

@Data
//模块表
public class Module {
	private Integer m_id;	//模块id
	private String m_name;	//模块名称
	private Integer m_parentId;	//父模块id
	private String m_path;	//模块路径
	private Integer m_weight;	//模块权重

}
