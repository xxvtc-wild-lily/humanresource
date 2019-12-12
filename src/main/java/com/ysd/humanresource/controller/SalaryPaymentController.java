package com.ysd.humanresource.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.PayrollRecord;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.service.SalaryPaymentService;

@RestController
public class SalaryPaymentController {
	
	@Autowired
	private SalaryPaymentService salaryPaymentService;
	
	@PostMapping("/getAllPositionSalaryPayment")
	public Pagination<Position> getAllPositionSalaryPayment(Integer page,@RequestParam("rows") Integer pageSize,Pagination<Position> pagination) {
		pagination.setPage((page-1)*pageSize);
		pagination.setPageSize(pageSize);
		return salaryPaymentService.selectDepartmentSalaryPaymentInfo(pagination);
	}
	
	@PostMapping("/getEmployeeCount")
	public Integer getEmployeeCount() {
		return salaryPaymentService.selectAllEmployeeCount();
	}
	
	@PostMapping("/addPayrollRecord")
	public Integer addPayrollRecord(String rows) {
		return salaryPaymentService.insertPayrollRecord(rows);
	}
	
	@PostMapping("/getNotAuditPayrollRecord")
	public List<PayrollRecord> getNotAuditPayrollRecord() {
		return salaryPaymentService.selectAllNotAduitPayrollRecord();
	}
	
	@PostMapping("/examinePayrollRecord")
	public Integer examinePayrollRecord(PayrollRecord payrollRecord) {
		return salaryPaymentService.updatePayrollRecordAduitStatus(payrollRecord);
	}
	
	@PostMapping("/getAllPayrollRecord")
	public List<PayrollRecord> getPassedAuditPayrollRecord(Integer page,@RequestParam("rows") Integer pageSize,Pagination<Position> pagination) {
		pagination.setPage((page-1)*pageSize);
		pagination.setPageSize(pageSize);
		return salaryPaymentService.selectAllPayrollRecord(pagination);
	}
	
	@PostMapping("/getAllDepartmentTree")
	public List<HashMap<String,Object>> getAllDepartmentTree() {
		return salaryPaymentService.getAllDepartmentTree();
	}
	
	@PostMapping("/getAllSalaryStandard")
	public List<SalaryStandard> getAllSalaryStandard() {
		return salaryPaymentService.getAllSalaryStandard();
	}
	
	@PostMapping("/editSalaryStandard")
	public Integer editSalaryStandard(Position position) {
		return salaryPaymentService.editSalaryStandard(position);
	}
	
	@PostMapping("/getSalaryPaymentByPosition")
	public List<Position> getSalaryPaymentByPosition(Position position) {
		return salaryPaymentService.selectSalaryPaymentByPosition(position);
	}
	
	@PostMapping("/pay")
	public Integer pay(PayrollRecord payrollRecord) {
		return salaryPaymentService.updatePayrollRecordPayStatus(payrollRecord);
	}
	
}
