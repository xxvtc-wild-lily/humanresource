package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.DTO.PayrollRecordDTO;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;

public interface SalaryPaymentMapper {
	
	/**
	 * 查询薪酬发放信息
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的符合条件的薪酬发放信息
	 */
	List<Position> selectDepartmentSalaryPaymentInfo(Pagination pagination);
	
	/**
	 * 查询薪酬发放信息数量
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的符合条件的薪酬发放信息数量
	 */
	Integer selectDepartmentSalaryPaymentInfoCount(Pagination pagination);
	
	/**
	 * 查询所有员工数量
	 * @return 查询到的员工数量
	 */
	Integer selectAllEmployeeCount();
	
	/**
	 * 添加薪酬发放记录
	 * @param rows 包含薪酬发放信息的list集合
	 * @return 受影响的行数
	 */
	Integer insertPayrollRecord(List<PayrollRecordDTO> rows);
	
}
