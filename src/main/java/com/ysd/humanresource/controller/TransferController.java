package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.service.TransferService;
@RestController
public class TransferController {
	@Autowired
	private TransferService transferService;
	
	@PostMapping("/selectByStatus")
	public List<Account> selectByStatus(Account account){
		List<Account> list=transferService.selectByStatus(account);
		return list;
	}
	
	@PostMapping("/updateTransfer")
	public Integer updateTransfer(Employee employee) {
		Integer updateTransfer = transferService.updateTransfer(employee);
		return updateTransfer;
	}
	
}
