package com.ysd.humanresource.entity;

import lombok.Data;

@Data
//角色模块中间表
public class RoleModule {
	private Integer rm_id;	//角色模块id
	private Integer r_id;	//角色id
	private Integer m_id;	//模块id

}
