package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Position;

public interface DepartmentService {
	/**
	 * 查询所有部门及职位
	 * @return
	 */
	public List<Department> selectDepAll();
}
