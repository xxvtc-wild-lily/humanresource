package com.ysd.humanresource.service;

import java.util.HashMap;
import java.util.List;

import com.ysd.humanresource.entity.Module;

public interface ModuleManageService {
	
	/**
	 * 查询全部模块
	 * @return 查询到的模块信息集合
	 */
	List<HashMap<String,Object>> selectAllModule();
	
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
	 * 修改子模块为父模块
	 * @param module 包含修改信息的模块实体类
	 * @return 受影响的行数
	 */
	Integer updateChildrenModuleToParentModule(Module module);
	
}
