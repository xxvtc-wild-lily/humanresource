package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.humanresource.dao.TransferrecordMapper;
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
	@Transactional
	public Integer updateTransfer(TransFerrecord transFerrecord) {
		// TODO Auto-generated method stub
		transferrecordMapper.updateTransfer(transFerrecord);
		System.out.println(transFerrecord);
		Integer pos_id = transferrecordMapper.selectPosNameId(transFerrecord);
		transFerrecord.setPos_id(pos_id);
		return transferrecordMapper.updateEmployee(transFerrecord);
	}

	@Override
	public Integer updateTransferno(TransFerrecord transFerrecord) {
		// TODO Auto-generated method stub
		return transferrecordMapper.updateTransferno(transFerrecord);
	}

}
