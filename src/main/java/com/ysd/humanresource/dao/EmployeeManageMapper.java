package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.EmployeeRole;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.Role;

public interface EmployeeManageMapper {
	
	/**
	 * 分页查询所有员工数据
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的员工数据
	 */
	List<Employee> selectAllEmployee(Pagination<Employee> pagination);
	
	/**
	 * 根据条件查询所有员工数量
	 * @param pagination 包含分页信息的分页类
	 * @return 查询到的员工数据
	 */
	Integer selectAllEmployeeCount(Pagination<Employee> pagination);
	
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
	Integer updateEmployeeInfo(Employee employee);
	
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
	 * @param list 包含要添加的信息的角色list
	 * @return 受影响的行数
	 */
	Integer insertRoleByEmployee(List<EmployeeRole> list);
	
	/**
	 * 根据员工id批量删除角色信息
	 * @param list 包含要删除的信息的角色list
	 * @return 受影响的行数
	 */
	Integer deleteRoleByEmployee(List<EmployeeRole> list);
	
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
	 * 查询是否有相同的盐码
	 * @param salt 传过来的需要查重的盐码
	 * @return 查询到的符合条件的条数
	 */
	Integer selectIsHaveSameSalt(String salt);
	
	/**
	 * 查询是否有相同的手机号
	 * @param account 包含手机号的实体类
	 * @return 查询到的行数
	 */
	Integer selectIsHaveSameTelPhone(Account account);
	
	/**
	 * 查询是否有相同的邮箱
	 * @param account 包含邮箱的实体类
	 * @return 查询到的行数
	 */
	Integer selectIsHaveSameEmail(Account account);
	
	/**
	 * 修改账号状态为未锁定
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
	 * 修改账号密码信息为默认信息
	 * @param account 包含账号信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountPasswordToDefault(Account account);
	
	/**
	 * 修改账号状态为已锁定
	 * @param account 包含账号信息的实体类
	 * @return 受影响的行数
	 */
	Integer updateAccountLock(Account account);
	
}
