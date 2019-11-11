package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.DepartmentMapper;
import com.ysd.humanresource.dao.PositionMapper;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper depmap;
	@Override
	/* 查询所有部门 */
	public List<Department> selectDepAll() {
		List<Department> selectDepAndPosAll = depmap.selectDepAll();
		return selectDepAndPosAll;
	}
}
