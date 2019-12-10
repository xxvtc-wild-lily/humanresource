package com.ysd.humanresource.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.service.ModuleManageService;

@RestController
public class ModuleManageController {
	
	@Autowired
	private ModuleManageService moduleManageService;
	
	@PostMapping("/getAllModule")
	public List<HashMap<String, Object>> getAllModule() {
		return moduleManageService.selectAllModule();
	}
	
	@PostMapping("/addChildrenZone")
	public Integer addChildrenZone(Module module) {
		return moduleManageService.insertChildrenModule(module);
	}
	
	@PostMapping("/addParentZone")
	public Integer addParentZone(Module module) {
		return moduleManageService.insertParentMoudle(module);
	}
	
	@PostMapping("/getParentNode")
	public List<Module> getParentNode() {
		return moduleManageService.selectAllParentModule();
	}
	
	@PostMapping("/editZone")
	public Integer editZone(Module module) {
		return moduleManageService.updateModuleById(module);
	}
	
	@PostMapping("/judgeStatus")
	public Integer judgeStatus(Module module) {
		return moduleManageService.selectCurrentModuleUseNumber(module);
	}
	
	@PostMapping("/addSchemeTwoChildrenZone")
	public Integer addSchemeTwoChildrenZone(Module module) {
		return moduleManageService.updateChildrenModuleToParentModule(module);
	}
	
}
