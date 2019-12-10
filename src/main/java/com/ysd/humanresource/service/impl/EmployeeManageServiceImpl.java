package com.ysd.humanresource.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.humanresource.DTO.EmployeeDTO;
import com.ysd.humanresource.dao.EmployeeManageMapper;
import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.EmployeeRole;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.Role;
import com.ysd.humanresource.enums.AccountLockStatusEnum;
import com.ysd.humanresource.service.EmployeeManageService;
import com.ysd.humanresource.util.PasswordUtil;

@Service
public class EmployeeManageServiceImpl implements EmployeeManageService {
	
	@Autowired
	private EmployeeManageMapper employeeManageMapper;

	@Override
	public Pagination<Employee> selectAllEmployee(Pagination<Employee> pagination) {
		// TODO Auto-generated method stub
		pagination.setRows(employeeManageMapper.selectAllEmployee(pagination));
		pagination.setTotal(employeeManageMapper.selectAllEmployeeCount(pagination));
		return pagination;
	}
	
	@Override
	public List<Department> selectAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list = employeeManageMapper.selectAllDepartment();
		Department dep = new Department();
		dep.setDep_id(0);
		dep.setDep_name("--请选择--");
		list.add(0,dep);
		return list;
	}

	@Override
	public List<Position> selectAllPosition(Department department) {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectAllPosition(department);
	}

	@Override
	public Integer updateEmployeeInfo(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		
		Employee employee = new Employee();
		Encoder encoder = Base64.getEncoder();
		byte[] imageByte = null;
		try {
			// 将图片转为字节码
			imageByte = encoder.encode(employeeDTO.getEmp_picture().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 将字节码转为String类型
		String image = new String(imageByte);
		// 复制属性值
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setEmp_picture(image);
        
		return employeeManageMapper.updateEmployeeInfo(employee);
	}

	@Override
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectAllRole();
	}

	@Override
	public List<Role> selectRoleByEmployee(Integer emp_id) {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectRoleByEmployee(emp_id);
	}

	@Override
	public Integer insertRoleByEmployee(String arr, Integer emp_id) {
		// TODO Auto-generated method stub
		
		String[] splitArr = arr.split(",");
		List<EmployeeRole> list = new ArrayList<EmployeeRole>();
		for (int i = 0;i < splitArr.length;i++) {
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setR_id(Integer.parseInt(splitArr[i]));
			employeeRole.setEmp_id(emp_id);
			list.add(employeeRole);
		}
		
		return employeeManageMapper.insertRoleByEmployee(list);
	}

	@Override
	public Integer deleteRoleByEmployee(String arr, Integer emp_id) {
		// TODO Auto-generated method stub
		
		String[] splitArr = arr.split(",");
		List<EmployeeRole> list = new ArrayList<EmployeeRole>();
		for (int i = 0;i < splitArr.length;i++) {
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setR_id(Integer.parseInt(splitArr[i]));
			employeeRole.setEmp_id(emp_id);
			list.add(employeeRole);
		}
		
		return employeeManageMapper.deleteRoleByEmployee(list);
	}

	@Override
	public Account selectAccountByEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectAccountByEmployee(employee);
	}

	@Override
	@Transactional
	public Integer insertAccount(Account account) {
		// TODO Auto-generated method stub
		
		Integer sameTelPhone = employeeManageMapper.selectIsHaveSameTelPhone(account);
		
		// 判断是否有相同的手机号
		if (sameTelPhone == 0) {
			Integer sameEmail = employeeManageMapper.selectIsHaveSameEmail(account);
			// 判断是否有相同的邮箱
			if (sameEmail == 0) {
				
				String salt = PasswordUtil.randomFingerprintNumber();
				Integer sameRow = employeeManageMapper.selectIsHaveSameSalt(salt);
				// 如果有重复的就进行循环直到没有重复的
				while (sameRow > 0) {
					salt = PasswordUtil.randomFingerprintNumber();
					sameRow = employeeManageMapper.selectIsHaveSameSalt(salt);
				}
				String password = PasswordUtil.generate(account.getAcc_password(), salt);
				account.setAcc_salt(salt);
				account.setAcc_password(password);
				
				return employeeManageMapper.insertAccount(account);
				
			} else {
				return -2;
			}
		} else {
			return -1;
		}
		
	}

	@Override
	public Integer updateAccountStatusUnLock(Account account) {
		// TODO Auto-generated method stub
		account.setAcc_lockStatus(AccountLockStatusEnum.UNLCOK.getCode());
		return employeeManageMapper.updateAccountStatusUnLock(account);
	}

	@Override
	public Account selectAccountById(Account account) {
		// TODO Auto-generated method stub
		return employeeManageMapper.selectAccountById(account);
	}

	@Override
	@Transactional
	public Integer updateAccountPasswordToDefault(Account account) {
		// TODO Auto-generated method stub
		Account accountInfo = employeeManageMapper.selectAccountById(account);
		String password = PasswordUtil.generate("ysd123", accountInfo.getAcc_salt());
		accountInfo.setAcc_password(password);
		return employeeManageMapper.updateAccountPasswordToDefault(accountInfo);
	}

	@Override
	public Integer lockAccount(Account account) {
		// TODO Auto-generated method stub
		account.setAcc_lockStatus(AccountLockStatusEnum.LOCK.getCode());
		return employeeManageMapper.updateAccountLock(account);
	}
	
}
