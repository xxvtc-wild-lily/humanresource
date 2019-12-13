package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Fenye;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.service.EmployeeSer;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeSer empser;	
	
	@RequestMapping(value="/empFenye",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Employee> empFenye(Fenye<Employee> fenye,Integer page,Integer rows,Employee employee){
			fenye.setPage(page);
			fenye.setPageSize(rows);
			fenye.setT(employee);
		return empser.empFenye(fenye);
		
	}
	
	@RequestMapping(value="/empBoss",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Employee> empBoss(Fenye<Employee> fenye,Integer page,Integer rows,Employee employee) {
		// TODO Auto-generated method stub
		fenye.setPage(page);
		fenye.setPageSize(rows);
		fenye.setT(employee);
		return empser.empBoss(fenye);
	}
	
	@RequestMapping(value="/selPos",method = RequestMethod.POST)
	@ResponseBody
	public List<Position> selPos() {
		// TODO Auto-generated method stub
		return empser.selPos();
	}
	
	@RequestMapping(value="/AddUser",method = RequestMethod.POST)
	@ResponseBody
	public Integer AddUser(Employee employee) {
		// TODO Auto-generated method stub
		return empser.AddUser(employee);
	}
	
	@RequestMapping(value="/empDel",method = RequestMethod.POST)
	@ResponseBody
	public Integer empDel(String Id) {
		// TODO Auto-generated method stub
		return empser.empDel(Id);
	}
	
	
	@RequestMapping(value="/upEmp",method = RequestMethod.POST)
	@ResponseBody
	public Integer upEmp(Employee employee) {
		// TODO Auto-generated method stub
		return empser.upEmp(employee);
	}
}
