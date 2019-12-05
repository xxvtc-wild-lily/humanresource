package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.TransFerrecord;
import com.ysd.humanresource.service.TransferrecordService;

@RestController
public class TransferrecordController {
	
	@Autowired
	private TransferrecordService transferrecordService;
	
	@PostMapping("/selectTrans")
	public List<TransFerrecord> selectTrans(TransFerrecord transFerrecord){
		List<TransFerrecord> selectTrans = transferrecordService.selectTransFerrecordStatus(transFerrecord);
		return selectTrans;
	}
	@PostMapping("/updateTransfer")
	public Integer updateTransfer(TransFerrecord transFerrecord) {
		
		System.out.println(transFerrecord);
		
		// TODO Auto-generated method stub
		Integer updateTransfer = transferrecordService.updateTransfer(transFerrecord);
		return updateTransfer;
	}
}
