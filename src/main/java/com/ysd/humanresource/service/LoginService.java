package com.ysd.humanresource.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;

public interface LoginService {
	
	/**
	 * 登录方法
	 * @param account 包含登录账号信息的实体类
	 * @return Map集合
	 */
	Map<String,Object> login(Account account);
	
	/**
	 * 验证token的方法
	 * @param token 传过来的token数据
	 * @return token是否正确(true/false)
	 */
	boolean verifyToken(String token);
	
	/**
	 * 查询到的登录用户的权限树
	 * @param employee 包含当前登录用户信息的实体类
	 * @return 查询到的权限树
	 */
	List<HashMap<String,Object>> initTree(Employee employee);
	
	/**
	 * 判断旧密码是否正确
	 * @param account 包含账号信息的账号类
	 * @return 状态码
	 */
	Integer checkOldPassword(Account account);
	
	/**
	 * 修改员工密码
	 * @param account 包含账号信息的账号类
	 * @return 受影响的行数
	 */
	Integer updatePassword(Account account);
	
}
