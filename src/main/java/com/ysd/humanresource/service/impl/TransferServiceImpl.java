package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.TransferMapper;
import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.service.TransferService;
@Service
public class TransferServiceImpl implements TransferService {
	@Autowired
	private TransferMapper transferMapper;

	@Override
	public List<Account> selectByStatus(Account account) {
		// TODO Auto-generated method stub
		List<Account> selectByStatus = transferMapper.selectByStatus(account);
		return selectByStatus;
	}
}
