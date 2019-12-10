package com.ysd.humanresource.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.humanresource.dao.ModuleManageMapper;
import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.entity.RoleModule;
import com.ysd.humanresource.service.ModuleManageService;

@Service
public class ModuleManageServiceImpl implements ModuleManageService  {
	
	@Autowired
	private ModuleManageMapper moduleManageMapper;
	
	public List<HashMap<String,Object>> selectAllModule() {
        // 查询出的树结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        // 查询出的用户的所有模块
        List<Module> list = moduleManageMapper.selectAllModule();
        
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getM_parentId() == 0) {
            	
                HashMap<String,Object> map = new HashMap<String, Object>();
                
                // 存放attributes属性的HashMap
                HashMap<String,Object> attributesMap = new HashMap<String,Object>();
                
                map.put("id",list.get(i).getM_id());
                map.put("text",list.get(i).getM_name());
                map.put("state","open");
                attributesMap.put("m_path",list.get(i).getM_path());
                attributesMap.put("m_weight",list.get(i).getM_weight());
                attributesMap.put("m_parentId", list.get(i).getM_parentId());
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
                attributesMap.put("m_weight",list.get(i).getM_weight());
                attributesMap.put("m_parentId", list.get(i).getM_parentId());
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
	public Integer insertChildrenModule(Module module) {
		// TODO Auto-generated method stub
		return moduleManageMapper.insertChildrenModule(module);
	}

	@Override
	public Integer insertParentMoudle(Module module) {
		// TODO Auto-generated method stub
		return moduleManageMapper.insertParentMoudle(module);
	}

	@Override
	public List<Module> selectAllParentModule() {
		// TODO Auto-generated method stub
		return moduleManageMapper.selectAllParentModule();
	}

	@Override
	public Integer updateModuleById(Module module) {
		// TODO Auto-generated method stub
		return moduleManageMapper.updateModuleById(module);
	}

	@Override
	@Transactional
	public Integer selectCurrentModuleUseNumber(Module module) {
		// TODO Auto-generated method stub
		
		Integer useNumber = moduleManageMapper.selectCurrentModuleUseNumber(module);
		
		// 如果当前模块没有人使用就将当前模块路径设置为空
		if (useNumber == 0) {
			return moduleManageMapper.updateModulePathById(module);
		} else {
			return 0;
		}
		
	}

	@Override
	@Transactional
	public Integer updateChildrenModuleToParentModule(Module module) {
		// TODO Auto-generated method stub
		
		Integer m_id = module.getM_id();
		
		Integer code = moduleManageMapper.insertChildrenModule(module);
		// 如果大于0则说明添加成功
		if (code > 0) {
			// 添加成功子模块后修改父模块路径
			moduleManageMapper.updateModulePathById(module);
			// 之后查询权限模块中间表里有包含将要变成父模块的模块id的信息
			List<RoleModule> list = moduleManageMapper.selectAllRoleModuleByMid(module);
			// 查询新添加的子模块id
			Integer id = moduleManageMapper.selectNewModuleIdByParentId(module);
			// 向list里循环添加新的分区id
			for (int i = 0;i < list.size();i++) {
				list.get(i).setM_id(id);
			}
			return moduleManageMapper.insertNewRoleModuleInfo(list);
		} else {
			return 0;
		}
		
	}
	
}
