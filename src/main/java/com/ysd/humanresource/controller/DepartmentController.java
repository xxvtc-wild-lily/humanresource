package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.service.DepartmentService;
@RestController
public class DepartmentController {
	private DepartmentService depser;
	@PostMapping("/selectdep")
	public List<Department> selectDepPosAll(){
		List<Department> selectDepAll = depser.selectDepAll();
		return selectDepAll;
	}
	@PostMapping("/selectpos")
	public List<Department> selectPosByDepid(Department de){
		List<Department> selectPosByDepid = depser.selectPosByDepid(de);
		return selectPosByDepid;
		
	}
}
