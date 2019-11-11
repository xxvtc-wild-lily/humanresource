package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysd.humanresource.dao.DepartmentMapper;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper depmap;
	@Override
	/* 查询所有部门 */
	public List<Department> selectDepAll() {
		List<Department> selectDepAndPosAll = depmap.selectDepAll();
		return selectDepAndPosAll;
	}
	@Override
	/* 根据部门查询职位 */
	public List<Department> selectPosByDepid(Department de) {
		List<Department> selectPosByDepId = depmap.selectPosByDepId(de);
		return selectPosByDepId;
	}

}
