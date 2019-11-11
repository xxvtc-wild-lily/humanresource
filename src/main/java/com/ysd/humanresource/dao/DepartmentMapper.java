package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Department;

public interface DepartmentMapper {
	/**
	 * 查询所有部门
	 * @return
	 */
	List<Department> selectDepAll();
	/**
	 * 根据部门查询职位
	 * @return
	 */
	List<Department> selectPosByDepId(Department dep);
}
