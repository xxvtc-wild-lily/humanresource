package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Account;

public interface TransferMapper {
	List<Account> selectByStatus(Account account);
}
