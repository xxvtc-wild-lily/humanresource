package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.EmployeeManageMapper;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.service.EmployeeManageService;

@Service
public class EmployeeManageServiceImpl implements EmployeeManageService {
	
	@Autowired
	private EmployeeManageMapper employeeManageMapper;

	@Override
	public Pagination<Employee> selectAllEmployee(Pagination<Employee> pagination) {
		// TODO Auto-generated method stub
		pagination.setRows(employeeManageMapper.selectAllEmployee(pagination));
		pagination.setTotal(employeeManageMapper.selectAllEmployeeCount(pagination));
		return pagination;
	}
	
	@Override
	public List<Department> selectAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list = employeeManageMapper.selectAllDepartment();
		Department dep = new Department();
		dep.setDep_id(0);
		dep.setDep_name("--请选择--");
		list.add(0,dep);
		return list;
	}

	@Override
	public List<Position> selectAllPosition(Department department) {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectAllPosition(department);
	}
	
}
