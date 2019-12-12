package com.ysd.humanresource.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.humanresource.dao.LoginMapper;
import com.ysd.humanresource.entity.Account;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.service.LoginService;
import com.ysd.humanresource.util.PasswordUtil;
import com.ysd.humanresource.util.TokenUtil;

import io.jsonwebtoken.Claims;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	@Transactional
	public Map<String,Object> login(Account account) {
		// TODO Auto-generated method stub
		
		// 返回的Map
		Map<String,Object> map = new HashMap<String,Object>();
		
		Account telAccount = loginMapper.selectAccountByTelPhone(account);
		// 判断登录账号是否为手机号
		if (telAccount != null) {
			Integer isLock = loginMapper.selectAccountLockStatus(telAccount);
			// 判断是否锁定
			if (isLock != 1) {
				// 调用公共的登录方法
				map = publicLoginMethod(account, telAccount);
			} else {
				map.put("code",2);
			}
		} else {
			Account emailAccount = loginMapper.selectAccountByEamil(account);
			// 判断登录账号是否为邮箱
			if (emailAccount != null) {
				Integer isLock = loginMapper.selectAccountLockStatus(emailAccount);
				// 判断是否锁定
				if (isLock != 1) {
					// 调用公共的登录方法
					map = publicLoginMethod(account, emailAccount);
				} else {
					map.put("code",2);
				}
			} else {
				map.put("code",1);
			}
		}
		
		return map;
	}
	
	// 登录方法调用的公共方法
	public Map<String,Object> publicLoginMethod(Account acceptAccount,Account queryAccount) {
		
		// 返回的Map
		Map<String,Object> map = new HashMap<String,Object>();
		// 根据用户输入的密码生成加密后的密码
		String md5Password = PasswordUtil.generate(acceptAccount.getAcc_password(), queryAccount.getAcc_salt());
		
		// 判断密码是否正确
		if (md5Password.equals(queryAccount.getAcc_password())) {
			Integer code = loginMapper.updateAccountInfoBecauseLoginSuccess(queryAccount);
			// 当修改失败时重新修改直至成功
			while(code == 0) {
				code = loginMapper.updateAccountInfoBecauseLoginSuccess(queryAccount);
			}
			Employee employee = loginMapper.selectEmployeeById(queryAccount.getEmp_id());
			String token = TokenUtil.createToken(String.valueOf(employee.getEmp_id()), employee.getEmp_name(), new Date());
			map.put("token", token);
			map.put("emp_id", employee.getEmp_id());
			map.put("emp_name", employee.getEmp_name());
			map.put("code",4);
		} else {
			Integer wrongTimes = loginMapper.selectAccountPasswordWrongTimes(queryAccount);
			if (wrongTimes >= 3) {
				map.put("code",2);
			} else {
				loginMapper.updateAccountPasswordWrongTimes(queryAccount);
				map.put("code",3);
				map.put("chance", 3 - wrongTimes);
			}
		}
		
		return map;
	}

	@Override
	public boolean verifyToken(String token) {
		// TODO Auto-generated method stub
		
		// 判断token是否为空
		if (token != null && token != "" && !token.isEmpty()) {
			Claims parserTonken = TokenUtil.parserTonken(token);
			Employee employee = loginMapper.selectEmployeeById(Integer.parseInt(parserTonken.getId()));
			
			// 判断token中的数据是否与数据库中该token对应的数据一致
			if (employee.getEmp_name().equals(parserTonken.getSubject())) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public List<HashMap<String, Object>> initTree(Employee employee) {
		// TODO Auto-generated method stub
		
		// 查询出的树结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        // 查询出当前登录用户的所有模块
        List<Module> list = loginMapper.selectModuleByEmployee(employee);
        
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getM_parentId() == 0) {
            	
                HashMap<String,Object> map = new HashMap<String, Object>();
                
                // 存放attributes属性的HashMap
                HashMap<String,Object> attributesMap = new HashMap<String,Object>();
                
                map.put("id",list.get(i).getM_id());
                map.put("text",list.get(i).getM_name());
                map.put("state","open");
                attributesMap.put("m_path",list.get(i).getM_path());
                map.put("attributes",attributesMap);
                map.put("children",getChildren(list.get(i).getM_id(),list));
                treeData.add(map);
            }
        }
        
        return treeData;
	}
	
	public List<HashMap<String,Object>> getChildren(Integer m_id,List<Module> list) {
        // 查询出的children结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getM_parentId() == m_id) {
                HashMap<String,Object> map = new HashMap<String, Object>();
                
                // 存放attributes属性的HashMap
                HashMap<String,Object> attributesMap = new HashMap<String,Object>();
                
                map.put("id",list.get(i).getM_id());
                map.put("text",list.get(i).getM_name());
                map.put("state","open");
                attributesMap.put("m_path",list.get(i).getM_path());
                map.put("attributes",attributesMap);
                for (int j = 0;j< list.size();j++) {
                    if (list.get(j).getM_parentId() == list.get(i).getM_id()) {
                        map.put("children",getChildren(list.get(i).getM_id(),list));
                    } else {
                        map.put("attribute",list.get(i).getM_path());
                    }
                }
                treeData.add(map);
            }
        }
        
        return treeData;
    }

	@Override
	public Integer checkOldPassword(Account account) {
		// TODO Auto-generated method stub
		
		System.out.println("进入");
		// 查找员工id对应的账号信息
		Account accountInfo = loginMapper.selectAccountByEmployee(account);
		
		// 根据输入的旧密码生成加密后的密码
		String newPassword = PasswordUtil.generate(account.getAcc_password(), accountInfo.getAcc_salt());
		
		System.out.println("inputPassword:"+account.getAcc_password());
		System.out.println("salt:"+accountInfo.getAcc_salt());
		System.out.println("newPassword:"+newPassword);
		
		// 判断原密码是否正确
		if (newPassword.equals(accountInfo.getAcc_password())) {
			System.out.println("1");
			return 1;
		} else {
			System.out.println("1");
			return 2;
		}
		
	}

	@Override
	public Integer updatePassword(Account account) {
		// TODO Auto-generated method stub
		
		// 查找员工id对应的账号信息
		Account accountInfo = loginMapper.selectAccountByEmployee(account);
		
		// 根据输入的新密码生成加密后的密码
		String password = PasswordUtil.generate(account.getAcc_password(), accountInfo.getAcc_salt());
		
		accountInfo.setAcc_password(password);
		
		return loginMapper.updateAccountPassword(accountInfo);
	}
	
}
