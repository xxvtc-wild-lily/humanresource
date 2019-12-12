package com.ysd.humanresource.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public Map<String,Object> login(Account account) {
		return loginService.login(account);
	}
	
	@PostMapping("/verifyToken")
	public boolean verifyToken(String token) {
		return loginService.verifyToken(token);
	}
	
	@PostMapping("/initTree")
	public List<HashMap<String,Object>> initTree(Employee employee) {
		return loginService.initTree(employee);
	}
	
	@PostMapping("checkOldPasswordIsRight")
	public Integer checkOldPasswordIsRight(Account account) {
		System.out.println(account.toString());
		return loginService.checkOldPassword(account);
	}
	
	@PostMapping("/updatePassword")
	public Integer updatePassword(Account account) {
		return loginService.updatePassword(account);
	}
	
}
