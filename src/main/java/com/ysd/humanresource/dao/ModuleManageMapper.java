package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.entity.RoleModule;

public interface ModuleManageMapper {
	
	/**
	 * 查询全部模块
	 * @return 查询到的模块信息集合
	 */
	List<Module> selectAllModule();
	
	/**
	 * 添加子模块信息
	 * @param module 包含模块信息的模块类
	 * @return 受影响的行数
	 */
	Integer insertChildrenModule(Module module);
	
	/**
	 * 添加父模块信息
	 * @param module 包含模块信息的模块类
	 * @return 受影响的行数
	 */
	Integer insertParentMoudle(Module module);
	
	/**
	 * 查找全部父节点
	 * @return 查询到的父节点集合
	 */
	List<Module> selectAllParentModule();
	
	/**
	 * 根据id修改模块信息
	 * @param module 包含需要修改的模块信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateModuleById(Module module);
	
	/**
	 * 查询当前模块正在使用的人数
	 * @param module 包含查询信息的模块实体类
	 * @return 受影响的行数
	 */
	Integer selectCurrentModuleUseNumber(Module module);
	
	/**
	 * 根据模块id修改模块路径
	 * @param module 包含需要修改模块id的实体类
	 * @return 受影响的行数
	 */
	Integer updateModulePathById(Module module);
	
	/**
	 * 根据模块id修改模块路径
	 * @param module 包含需要修改模块的实体类
	 * @return 受影响的行数
	 */
	Integer updateParentModuleMpathById(Module module);
	
	/**
	 * 根据id查询权限模块中间表信息
	 * @param module 包含模块id的实体类
	 * @return 查询到的符合标准的集合
	 */
	List<RoleModule> selectAllRoleModuleByMid(Module module);
	
	/**
	 * 查询刚添加的新模块的id
	 * @param module 包含模块id的实体类
	 * @return 查询到的新模块id
	 */
	Integer selectNewModuleIdByParentId(Module module);
	
	/**
	 * 添加新的模块的模块中间表信息
	 * @param roleModule 包含角色模块信息的实体类
	 * @return 受影响的行数
	 */
	Integer insertNewRoleModuleInfo(List<RoleModule> roleModule);
	
}
