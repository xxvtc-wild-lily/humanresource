package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.service.DepartmentService;
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService depser;
	@PostMapping("/selectdep")
	public List<Department> selectDepPosAll(){
		System.out.println("!!!!!!!!!!");
		List<Department> selectDepAll = depser.selectDepAll();
		System.out.println(selectDepAll.toString());
		return selectDepAll;
	}
}
