package com.ysd.humanresource.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Role;
import com.ysd.humanresource.entity.RoleModule;
import com.ysd.humanresource.service.RoleManageService;

@RestController
public class RoleManageController {
	
	@Autowired
	private RoleManageService roleManageService;
	
	@PostMapping("/getAllRole")
	public Pagination<Role> getAllRole(Integer page,@RequestParam("rows") Integer pageSize,Pagination<Role> pagination) {
		pagination.setPage((page-1) * pageSize);
		pagination.setPageSize(pageSize);
		return roleManageService.selectAllRole(pagination);
	}
	
	@PostMapping("/editRoleInfo")
	public Integer editRoleInfo(Role role) {
		return roleManageService.updateRoleById(role);
	}
	
	@PostMapping("/getModuleByRole")
	public List<HashMap<String,Object>> getModuleByRole(Role role) {
		return roleManageService.selectRoleModule(role);
	}
	
	@PostMapping("/setNewRoleModule")
	public Integer setNewRoleModule(RoleModule roleModule,String idArray) {
		return roleManageService.updateRoleModule(roleModule, idArray);
	}
	
}
