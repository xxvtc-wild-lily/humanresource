package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Fenye;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;


public interface EmployeeMapper {
	
	
	/**
	 * 分页查询
	 * @param fenye
	 * @return
	 */
	List<Employee> empFenye(Fenye<Employee> fenye);

	/**
	 * 查询总条数
	 * @param fenye
	 * @return
	 */
	Integer empCon(Fenye<Employee> fenye);
	
	/**
	 * 查询职位
	 * @return
	 */
	List<Position> selPos();
	
	/**
	   * 添加档案
	 * @param employee 员工实体类
	 * @return
	 */
	Integer AddUser(Employee employee);
	/**
	 * 删除档案
	 * @param empid
	 * @return
	 */
	Integer empDel(String Id);
	
	
	/**
	 * 分页查询老大看的数据
	 * @param fenye
	 * @return
	 */
	List<Employee> empBoss(Fenye<Employee> fenye);

	/**
	 * 查询老大看的总条数
	 * @param fenye
	 * @return
	 */
	Integer empContwo(Fenye<Employee> fenye);
	/**
	 * 复核档案
	 * @param employee
	 * @return
	 */
	Integer upEmp(Employee employee);
}
