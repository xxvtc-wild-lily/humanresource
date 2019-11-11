package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Position;

public interface DepartmentMapper {
	/**
	 * 查询所有部门
	 * @return
	 */
	List<Department> selectDepAll();
	
}
