package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.TransFerrecord;

public interface TransferMapper {
	/**
	 * 查询所有状态的员工
	 * @param account
	 * @return
	 */
	List<Account> selectByStatus(Account account);
	
	Integer updateTransfer(Employee employee);
}
