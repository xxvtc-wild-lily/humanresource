package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.service.EmployeeManageService;

@RestController
public class EmployeeManageController {
	
	@Autowired
	private EmployeeManageService employeeManageService;
	
	@PostMapping("/getAllEmployee")
	public Pagination<Employee> getAllEmployee(Integer page,@RequestParam("rows") Integer pageSize,Pagination<Employee> pagination) {
		pagination.setPage((page-1) * pageSize);
		pagination.setPageSize(pageSize);
		return employeeManageService.selectAllEmployee(pagination);
	}
	
	@PostMapping("/getAllDepartment")
	public List<Department> getAllDepartment() {
		return employeeManageService.selectAllDepartment();
	}
	
	@PostMapping("/getAllPosition")
	public List<Position> getAllPosition(Department department) {
		return employeeManageService.selectAllPosition(department);
	}
	
}
