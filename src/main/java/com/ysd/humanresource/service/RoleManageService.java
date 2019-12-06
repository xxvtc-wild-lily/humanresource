package com.ysd.humanresource.service;

import java.util.HashMap;
import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Role;
import com.ysd.humanresource.entity.RoleModule;

public interface RoleManageService {
	
	/**
	 * 查询全部角色信息
	 * @return 查询到的角色集合
	 */
	Pagination<Role> selectAllRole(Pagination<Role> pagination);
	
	/**
	 * 根据id修改角色信息
	 * @param role 包含需要修改的角色信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateRoleById(Role role);
	
	/**
	 * 查询全部模块
	 * @param role 包含角色信息的实体类
	 * @return 查询到的模块信息集合
	 */
	List<HashMap<String,Object>> selectRoleModule(Role role);
	
	/**
	 * 根据传过来的信息更新角色所负责的模块
	 * @param roleModule 包含角色信息的角色模块类
	 * @param idArray 包含模块信息的模块数组
	 * @return
	 */
	Integer updateRoleModule(RoleModule roleModule,String idArray);
	
}
