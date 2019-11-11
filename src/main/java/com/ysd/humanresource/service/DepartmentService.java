package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Department;

public interface DepartmentService {
	/**
	 * 查询所有部门及职位
	 * @return
	 */
	public List<Department> selectDepAll();
	/**
	 * 根据部门查询职位
	 * @param dep_id
	 * @return
	 */
	public List<Department> selectPosByDepid(Department de);
}
