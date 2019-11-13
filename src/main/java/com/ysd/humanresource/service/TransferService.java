package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Account;

public interface TransferService {
	List<Account> selectByStatus(Account account);
}
