package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.SalaryStandard;

public interface SalaryStandardMapper {
	
	/**
	 * 添加薪酬标准
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 受影响的行数
	 */
	Integer insertSalaryStandard(SalaryStandard salaryStandard);
	
	/**
	 * 查询符合薪酬标准名称的薪酬标准数量
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 查询到的数量
	 */
	Integer selectCountBySalaryStandardName(SalaryStandard salaryStandard);
	
	/**
	 * 查询未审核的薪酬标准
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的未审核的薪酬标准集合
	 */
	List<SalaryStandard> selectAllUncheckSalaryStandard(Pagination pagination);
	
	/**
	 * 查询未审核的薪酬标准数量
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的未审核的薪酬标准数量
	 */
	Integer selectAllUncheckSalaryStandardCount(Pagination pagination);
	
	/**
	 * 根据薪酬标准姓名和id查找符合标准的薪酬标准数量
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 查询到的符合条件的数量
	 */
	Integer selectCountBySalaryStandardNameAndId(SalaryStandard salaryStandard);
	
	/**
	 * 根据薪酬标准id修改薪酬标准信息
	 * @param salaryStandard 包含薪酬标准信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateSalaryStandardById(SalaryStandard salaryStandard);
	
	/**
	 * 查询通过审核的薪酬标准
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的通过审核的薪酬标准集合
	 */
	List<SalaryStandard> selectAllCheckedSalaryStandard(Pagination pagination);
	
	/**
	 * 查询通过审核的薪酬标准数量
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的通过审核的薪酬标准数量
	 */
	Integer selectAllCheckedSalaryStandardCount(Pagination pagination);
	
}
