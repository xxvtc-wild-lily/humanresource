package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.TransFerrecord;

public interface TransferService {
	
	
	List<Account> selectByStatus(Account account);
	
	
	Integer updateTransfer(Employee employee);
}
