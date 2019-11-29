package com.ysd.humanresource.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ysd.humanresource.DTO.PayrollRecordDTO;
import com.ysd.humanresource.dao.SalaryPaymentMapper;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Position;
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
			
			PayrollRecordDTOList.get(i).setPr_ext2(SalaryPaymentStatusEnum.SALARYPAYMENTWAITADUIT.getCode());
			System.out.println(PayrollRecordDTOList.get(i).toString());
		}
		return salaryPaymentMapper.insertPayrollRecord(PayrollRecordDTOList);
	}
	
}
