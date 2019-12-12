package com.ysd.humanresource.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ysd.humanresource.DTO.PayrollRecordDTO;
import com.ysd.humanresource.dao.SalaryPaymentMapper;
import com.ysd.humanresource.entity.Department;
import com.ysd.humanresource.entity.Module;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.PayrollRecord;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.enums.SalaryPaymentStatusEnum;
import com.ysd.humanresource.service.SalaryPaymentService;

@Service
public class SalaryPaymentServiceImpl implements SalaryPaymentService {
	
	@Autowired
	private SalaryPaymentMapper salaryPaymentMapper;

	@Override
	public Pagination<Position> selectDepartmentSalaryPaymentInfo(Pagination<Position> pagination) {
		// TODO Auto-generated method stub
		
		List<Position> rows = salaryPaymentMapper.selectDepartmentSalaryPaymentInfo(pagination);
		Integer total = salaryPaymentMapper.selectDepartmentSalaryPaymentInfoCount(pagination);
		
		pagination.setRows(rows);
		pagination.setTotal(total);
		
		return pagination;
	}

	@Override
	public Integer selectAllEmployeeCount() {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.selectAllEmployeeCount();
	}

	@Override
	@Transactional
	public Integer insertPayrollRecord(String rows) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		// 将传过来的JSON数据转换为list集合
		List<PayrollRecordDTO> PayrollRecordDTOList =gson.fromJson(rows, new TypeToken<List<PayrollRecordDTO>>() {}.getType());
		// 拿到当前年月日数据
		String[] strNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
		Integer year = Integer.parseInt(strNow[0]);
		Integer month = Integer.parseInt(strNow[1]);
		Integer day = Integer.parseInt(strNow[2]);
		// 生成薪酬发放档案编号
		String pr_paySlipNumber = Integer.toString(year) + Integer.toString(month) + Integer.toString(day) + (int)((Math.random()*9+1)*100000);
		for (int i = 0;i < PayrollRecordDTOList.size();i++) {
			PayrollRecordDTOList.get(i).setPr_paySlipNumber(pr_paySlipNumber);
			PayrollRecordDTOList.get(i).setPr_ext1(String.valueOf(SalaryPaymentStatusEnum.SALARYPAYMENTWAITPAY.getCode()));
			PayrollRecordDTOList.get(i).setPr_ext2(SalaryPaymentStatusEnum.SALARYPAYMENTWAITADUIT.getCode());
		}
		return salaryPaymentMapper.insertPayrollRecord(PayrollRecordDTOList);
	}

	@Override
	public List<PayrollRecord> selectAllNotAduitPayrollRecord() {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.selectAllNotAduitPayrollRecord();
	}

	@Override
	public Integer updatePayrollRecordAduitStatus(PayrollRecord payrollRecord) {
		// TODO Auto-generated method stub
		payrollRecord.setPr_ext2(SalaryPaymentStatusEnum.SALARYPAYMENTPASSEDADUIT.getCode());
		return salaryPaymentMapper.updatePayrollRecordAduitStatus(payrollRecord);
	}

	@Override
	public List<PayrollRecord> selectAllPayrollRecord(Pagination pagination) {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.selectAllPayrollRecord(pagination);
	}

	@Override
	public List<HashMap<String, Object>> getAllDepartmentTree() {
		// TODO Auto-generated method stub
		
		// 查询出的树结构数据
        List<HashMap<String,Object>> treeData = new ArrayList<HashMap<String,Object>>();
        
        // 查询所有部门及岗位
        List<Department> list = salaryPaymentMapper.selectAllDepartment();
        
        for (int i = 0;i < list.size();i++) {
        	HashMap<String,Object> map = new HashMap<String, Object>();
        	// 子树结构数据
            List<HashMap<String,Object>> childrenTreeData = new ArrayList<HashMap<String,Object>>();
        	map.put("id",list.get(i).getDep_id());
            map.put("text",list.get(i).getDep_name());
            List<Position> positionList = salaryPaymentMapper.selectPositionByDepartment(list.get(i).getDep_id());
            for (int j = 0;j < positionList.size();j++) {
            	if (list.get(i).getDep_id() == positionList.get(j).getDep_id()) {
            		HashMap<String,Object> childrenMap = new HashMap<String, Object>();
                	childrenMap.put("id",positionList.get(j).getPos_id());
                	childrenMap.put("text",positionList.get(j).getPos_name());
                	childrenMap.put("attribute",positionList.get(j).getSs_id());
                	childrenTreeData.add(childrenMap);
            	}
            }
            map.put("children",childrenTreeData);
            treeData.add(map);
        }
		return treeData;
	}

	@Override
	public List<SalaryStandard> getAllSalaryStandard() {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.selectAllSalaryStandard();
	}

	@Override
	public Integer editSalaryStandard(Position position) {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.updatePositionSalaryStandard(position);
	}

	@Override
	public List<Position> selectSalaryPaymentByPosition(Position position) {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.selectSalaryPaymentByPosition(position);
	}

	@Override
	public Integer updatePayrollRecordPayStatus(PayrollRecord payrollRecord) {
		// TODO Auto-generated method stub
		return salaryPaymentMapper.updatePayrollRecordPayStatus(payrollRecord);
	}
	
}
