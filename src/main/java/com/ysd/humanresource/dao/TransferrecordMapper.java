package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.TransFerrecord;

public interface TransferrecordMapper {
	/**
	 * 查询所有调动状态未审核的记录
	 * @param transFerrecord
	 * @return
	 */
	List<TransFerrecord> selectTransFerrecordStatus(TransFerrecord transFerrecord);
	
	/**
	 * 员工调动管理员工调动信息审核记录表
	 * @param transFerrecord
	 * @return
	 */
	Integer updateTransfer(TransFerrecord transFerrecord);
	
	/**
	 * 查询记录表新职位和职位表职位相等的职位Id
	 * @param transFerrecord
	 * @return
	 */
	Integer selectPosNameId(TransFerrecord transFerrecord);
	
	/**
	 * 员工调动管理调动信息审核员工表
	 * @param employee
	 * @return
	 */
	Integer updateEmployee(TransFerrecord transFerrecord);
	
	
	
	/**
	 * 员工调动管理员工调动信息审核记录表
	 * @param transFerrecord
	 * @return
	 */
	Integer updateTransferno(TransFerrecord transFerrecord);
}
