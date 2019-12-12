package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Module;

public interface LoginMapper {
	
	/**
	 * 根据手机号查询账号信息
	 * @param account 包含登录信息的实体类
	 * @return 查询到的账号信息
	 */
	Account selectAccountByTelPhone(Account account);
	
	/**
	 * 根据邮箱查询账号信息
	 * @param account 包含登录信息的实体类
	 * @return 查询到的账号信息
	 */
	Account selectAccountByEamil(Account account);
	
	/**
	 * 查找账号锁定状态
	 * @param account 包含登录信息的实体类
	 * @return 查询到的锁定状态
	 */
	Integer selectAccountLockStatus(Account account);
	
	/**
	 * 查询当前账号错误次数
	 * @param account 包含登录信息的实体类
	 * @return 查询到的错误次数
	 */
	Integer selectAccountPasswordWrongTimes(Account account);
	
	/**
	 * 修改账号密码错误次数
	 * @param account 包含登录信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountPasswordWrongTimes(Account account);
	
	/**
	 * 登陆成功后修改账号信息
	 * @param account 包含登录信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountInfoBecauseLoginSuccess(Account account);
	
	/**
	 * 根据员工id搜索员工信息
	 * @param emp_id 员工id
	 * @return 查询到的员工信息
	 */
	Employee selectEmployeeById(Integer emp_id);
	
	/**
	 * 根据登录用户查找该用户所拥有的模块信息
	 * @param employee 包含登录用户信息的实体类
	 * @return 查询到的模块集合
	 */
	List<Module> selectModuleByEmployee(Employee employee);
	
	/**
	 * 根据员工信息查找对应的账号信息
	 * @param account 包含员工信息的实体类
	 * @return 查询到的账号信息
	 */
	Account selectAccountByEmployee(Account account);
	
	/**
	 * 修改账号密码
	 * @param account 包含要修改的账号的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountPassword(Account account);
	
}
