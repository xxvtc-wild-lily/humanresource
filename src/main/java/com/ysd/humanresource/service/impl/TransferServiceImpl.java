package com.ysd.humanresource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.TransferMapper;
import com.ysd.humanresource.service.TransferService;
@Service
public class TransferServiceImpl implements TransferService {
	@Autowired
	private TransferMapper transferMapper;
}
