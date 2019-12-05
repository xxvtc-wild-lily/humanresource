package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.TransFerrecord;

public interface TransferService {
	
	/**
	 * 查询所有状态的员工
	 * @param account
	 * @return
	 */
	List<Account> selectByStatus(Account account);
	
	/**
	 * 员工调动管理员工调动信息添加
	 * @param transFerrecord
	 * @return
	 */
	Integer insertTransfer(TransFerrecord transFerrecord);
	
}




