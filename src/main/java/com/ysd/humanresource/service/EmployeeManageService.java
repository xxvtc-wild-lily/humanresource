package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.DTO.EmployeeDTO;
import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.Role;

public interface EmployeeManageService {
	
	/**
	 * 分页查询所有员工数据
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的员工数据
	 */
	Pagination<Employee> selectAllEmployee(Pagination<Employee> pagination);
	
	/**
	 * 查询所有岗位信息
	 * @return 查询到的岗位信息
	 */
	List<Department> selectAllDepartment();
	
	/**
	 * 根据岗位查询该岗位的职位信息
	 * @param department 包含岗位信息的实体类
	 * @return 查询到的对应岗位的职位信息
	 */
	List<Position> selectAllPosition(Department department);
	
	/**
	 * 修改员工信息
	 * @param employee 包含员工信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateEmployeeInfo(EmployeeDTO employeeDTO);
	
	/**
	 * 查询全部角色信息
	 * @return 查询到的角色集合
	 */
	List<Role> selectAllRole();
	
	/**
	 * 根据员工查询角色
	 * @param emp_id 用来当作查询条件的员工id
	 * @return 查询到的角色集合
	 */
	List<Role> selectRoleByEmployee(Integer emp_id);
	
	/**
	 * 根据员工id批量添加角色信息
	 * @param arr 包含要添加角色信息的员工信息
	 * @param emp_id 要添加角色信息的员工id
	 * @return 受影响的行数
	 */
	Integer insertRoleByEmployee(String arr,Integer emp_id);
	
	/**
	 * 根据员工id批量删除角色信息
	 * @param arr 包含要删除角色信息的员工信息
	 * @param emp_id 要删除角色信息的员工id
	 * @return 受影响的行数
	 */
	Integer deleteRoleByEmployee(String arr,Integer emp_id);
	
	/**
	 * 根据员工id查询账号信息
	 * @param employee 包含员工信息的实体类
	 * @return 查询到的账号信息
	 */
	Account selectAccountByEmployee(Employee employee);
	
	/**
	 * 添加账号
	 * @param account 需要添加的账号信息
	 * @return 受影响的行数
	 */
	Integer insertAccount(Account account);
	
	/**
	 * 修改账户状态为未锁定
	 * @param account 包含账号信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountStatusUnLock(Account account);
	
	/**
	 * 根据账号查找对应的账号信息
	 * @param account 包含账号信息的实体类
	 * @return 查找到的账号信息
	 */
	Account selectAccountById(Account account);
	
	/**
	 * 重置密码
	 * @param account 包含账号信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountPasswordToDefault(Account account);
	
	/**
	 * 锁定账号
	 * @param account 包含账号信息的实体类
	 * @return 受影响的行数
	 */
	Integer lockAccount(Account account);
	
}
