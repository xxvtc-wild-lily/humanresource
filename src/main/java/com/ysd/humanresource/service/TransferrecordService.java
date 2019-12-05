package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.TransFerrecord;

public interface TransferrecordService {
	/**
	 * 查询所有调动状态未审核的记录
	 * @param transFerrecord
	 * @return
	 */
	List<TransFerrecord> selectTransFerrecordStatus(TransFerrecord transFerrecord);
	
	/**
	 * 员工调动管理员工调动信息审核
	 * @param transFerrecord
	 * @return
	 */
	Integer updateTransfer(TransFerrecord transFerrecord);
}
