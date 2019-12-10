package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;

public interface EmployeeManageService {
	
	/**
	 * 分页查询所有员工数据
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的员工数据
	 */
	Pagination<Employee> selectAllEmployee(Pagination<Employee> pagination);
	
	/**
	 * 查询所有岗位信息
	 * @return 查询到的岗位信息
	 */
	List<Department> selectAllDepartment();
	
	/**
	 * 根据岗位查询该岗位的职位信息
	 * @param department 包含岗位信息的实体类
	 * @return 查询到的对应岗位的职位信息
	 */
	List<Position> selectAllPosition(Department department);
	
}
