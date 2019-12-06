package com.ysd.humanresource.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.humanresource.dao.RoleManageMapper;
import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Role;
import com.ysd.humanresource.entity.RoleModule;
import com.ysd.humanresource.service.RoleManageService;

@Service
public class RoleManageServiceImpl implements RoleManageService {
	
	@Autowired
	private RoleManageMapper roleManageMapper;

	@Override
	public Pagination<Role> selectAllRole(Pagination<Role> pagination) {
		// TODO Auto-generated method stub
		
		pagination.setRows(roleManageMapper.selectAllRole(pagination));
		pagination.setTotal(roleManageMapper.selectAllRoleCount(pagination));
		
		return pagination;
	}

	@Override
	public Integer updateRoleById(Role role) {
		// TODO Auto-generated method stub
		return roleManageMapper.updateRoleById(role);
	}

	@Override
	public List<HashMap<String, Object>> selectRoleModule(Role role) {
		// TODO Auto-generated method stub
		// 树结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        // 查询出的用户的所有模块
        List<Module> list = roleManageMapper.selectAllModule();
        
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getM_parentId() == 0) {
            	
                HashMap<String,Object> map = new HashMap<String, Object>();
                
                map.put("id",list.get(i).getM_id());
                map.put("text",list.get(i).getM_name());
                map.put("state","open");
                map.put("children",getChildren(list.get(i).getM_id(),list,role));
                treeData.add(map);
            }
        }
        
        return treeData;
	}
	
	public List<HashMap<String,Object>> getChildren(Integer m_id,List<Module> list,Role role) {
        // 查询出的children结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        // 查询出的对应角色的模块
        List<Module> roleList = roleManageMapper.selectModuleByRole(role);
        
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getM_parentId() == m_id) {
                HashMap<String,Object> map = new HashMap<String, Object>();
                
                map.put("id",list.get(i).getM_id());
                map.put("text",list.get(i).getM_name());
                map.put("state","open");
                // 判断当前角色是否有该模块，如果有，就设置为选中状态
                for (int l = 0;l < roleList.size();l++) {
                	if (list.get(i).getM_id().equals(roleList.get(l).getM_id())) {
                		map.put("checked",true);
                	}
                }
                for (int j = 0;j< list.size();j++) {
                    if (list.get(j).getM_parentId() == list.get(i).getM_id()) {
                        map.put("children",getChildren(list.get(i).getM_id(),list,role));
                    }
                }
                treeData.add(map);
            }
        }
        
        return treeData;
    }

	@Override
	@Transactional
	public Integer updateRoleModule(RoleModule roleModule, String idArray) {
		// TODO Auto-generated method stub
		
		// 获取传过来的角色id
		Integer r_id = roleModule.getR_id();
		// 删除当前角色所有的角色模块信息
		roleManageMapper.deleteRoleModuleByRole(r_id);
		// 声明存放新的角色模块信息的集合
		List<RoleModule> list = new ArrayList<RoleModule>();
		// 将传过来的新模块id分割
		String[] splitArray = idArray.split(",");
		// 循环向list中添加新的角色模块信息
		for (int i = 0;i < splitArray.length;i++) {
			// 声明新的角色模块信息
			RoleModule roleModule2 = new RoleModule();
			roleModule2.setR_id(r_id);
			list.add(roleModule2);
			list.get(i).setM_id(Integer.parseInt(splitArray[i]));
		}
		
		return roleManageMapper.insertNewRoleModule(list);
	}
	
}
