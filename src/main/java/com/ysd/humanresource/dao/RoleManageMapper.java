package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Role;
import com.ysd.humanresource.entity.RoleModule;

public interface RoleManageMapper {
	
	/**
	 * 查询全部角色信息
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的角色集合
	 */
	List<Role> selectAllRole(Pagination<Role> pagination);
	
	/**
	 * 查询全部角色数量
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的角色数量
	 */
	Integer selectAllRoleCount(Pagination<Role> pagination);
	
	/**
	 * 根据id修改角色信息
	 * @param role 包含需要修改的角色信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateRoleById(Role role);
	
	/**
	 * 查询全部模块
	 * @return 查询到的模块信息集合
	 */
	List<Module> selectAllModule();
	
	/**
	 * 根据角色查询模块信息
	 * @param role 包含角色信息的实体类
	 * @return 查询到的模块集合
	 */
	List<Module> selectModuleByRole(Role role);
	
	/**
	 * 根据角色删除对应的角色模块信息
	 * @param r_id 需要删除的角色模块信息的角色id
	 * @return 受影响的行数
	 */
	Integer deleteRoleModuleByRole(Integer r_id);
	
	/**
	 * 根据传过来的list集合循环添加新的角色模块信息
	 * @param list 包含新的角色模块信息的集合
	 * @return 受影响的行数
	 */
	Integer insertNewRoleModule(List<RoleModule> list);
	
}
