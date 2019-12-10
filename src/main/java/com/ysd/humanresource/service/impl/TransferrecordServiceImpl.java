package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.TransferrecordMapper;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.TransFerrecord;
import com.ysd.humanresource.service.TransferrecordService;
@Service
public class TransferrecordServiceImpl implements TransferrecordService {
	
	@Autowired
	private TransferrecordMapper transferrecordMapper;
	
	@Override
	public List<TransFerrecord> selectTransFerrecordStatus(TransFerrecord transFerrecord) {
		// TODO Auto-generated method stub
		List<TransFerrecord> selectTransFerrecordStatus = transferrecordMapper.selectTransFerrecordStatus(transFerrecord);
		System.out.println(selectTransFerrecordStatus.toString());
		return selectTransFerrecordStatus;
	}

	@Override
	public Integer updateTransfer(TransFerrecord transFerrecord) {
		// TODO Auto-generated method stub
		Integer updateTransfer = transferrecordMapper.updateTransfer(transFerrecord);
		Integer updateEmployee = transferrecordMapper.updateEmployee(transFerrecord);
		List<TransFerrecord> selectPosNameId = transferrecordMapper.selectPosNameId(transFerrecord);
		System.out.println(updateTransfer);
		System.out.println(selectPosNameId);
		return updateTransfer;
	}

}
