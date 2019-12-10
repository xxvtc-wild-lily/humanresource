package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.DTO.EmployeeDTO;
import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.Role;
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
	
	@PostMapping("/editEmployee")
	public Integer editEmployee(EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO.toString());
		return employeeManageService.updateEmployeeInfo(employeeDTO);
	}
	
	@PostMapping("/getRole")
	public List<Role> getAllRole() {
		return employeeManageService.selectAllRole();
	}
	
	@PostMapping("/getEmployeeRole")
	public List<Role> getEmployeeRole(Integer emp_id) {
		return employeeManageService.selectRoleByEmployee(emp_id);
	}
	
	@PostMapping("/removeRoleToEmployee")
	public Integer removeRoleToEmployee(String arr,Integer emp_id) {
		return employeeManageService.insertRoleByEmployee(arr, emp_id);
	}
	
	@PostMapping("/removeEmployeeToAll")
	public Integer removeEmployeeToAll(String arr,Integer emp_id) {
		return employeeManageService.deleteRoleByEmployee(arr, emp_id);
	}
	
	@PostMapping("/getEmployeeAccount")
	public Account getEmployeeAccount(Employee employee) {
		return employeeManageService.selectAccountByEmployee(employee);
	}
	
	@PostMapping("/createAccount")
	public Integer createAccount(Account account) {
		return employeeManageService.insertAccount(account);
	}
	
	@PostMapping("/unLockAccount")
	public Integer unLockAccount(Account account) {
		return employeeManageService.updateAccountStatusUnLock(account);
	}
	
	@PostMapping("/getAccount")
	public Account getAccount(Account account) {
		return employeeManageService.selectAccountById(account);
	}
	
	@PostMapping("/resetPassword")
	public Integer resetPassword(Account account) {
		return employeeManageService.updateAccountPasswordToDefault(account);
	}
	
	@PostMapping("/lockAccount")
	public Integer lockAccount(Account account) {
		return employeeManageService.lockAccount(account);
	}
}
