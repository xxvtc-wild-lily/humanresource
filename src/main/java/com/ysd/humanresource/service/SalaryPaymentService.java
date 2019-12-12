package com.ysd.humanresource.service;

import java.util.HashMap;
import java.util.List;

import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.PayrollRecord;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;

public interface SalaryPaymentService {
	
	/**
	 * 查询薪酬发放信息
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的符合条件的薪酬发放信息
	 */
	Pagination<Position> selectDepartmentSalaryPaymentInfo(Pagination<Position> pagination);
	
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
	Integer insertPayrollRecord(String rows);
	
	/**
	 * 查询未审核的薪酬发放信息
	 * @return 查询到的薪酬发放信息集合
	 */
	List<PayrollRecord> selectAllNotAduitPayrollRecord();
	
	/**
	 * 修改薪酬发放信息状态
	 * @param payrollRecord 包含薪酬发放信息的实体类
	 * @return 受影响的行数
	 */
	Integer updatePayrollRecordAduitStatus(PayrollRecord payrollRecord);
	
	/**
	 * 查询所有薪酬发放信息
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的薪酬发放信息集合
	 */
	List<PayrollRecord> selectAllPayrollRecord(Pagination pagination);
	
	/**
	 * 获取岗位以及对应部门的树状数据
	 * @return 查询到的树状数据
	 */
	List<HashMap<String, Object>> getAllDepartmentTree();
	
	/**
	 * 查询所有薪酬标准
	 * @return 查询到的薪酬标准集合
	 */
	List<SalaryStandard> getAllSalaryStandard();
	
	/**
	 * 修改职位的薪酬标准
	 * @param position 包含修改信息的实体类
	 * @return 受影响的行数
	 */
	Integer editSalaryStandard(Position position);
	
	/**
	 * 根据职位查询薪酬发放信息
	 * @param position 包含职位信息的实体类
	 * @return 查询到的薪酬发放信息
	 */
	List<Position> selectSalaryPaymentByPosition(Position position);
	
	/**
	 * 修改薪酬单状态为已支付
	 * @param payrollRecord 包含要修改的薪酬单的信息
	 * @return 受影响的行数
	 */
	Integer updatePayrollRecordPayStatus(PayrollRecord payrollRecord);
	
}
