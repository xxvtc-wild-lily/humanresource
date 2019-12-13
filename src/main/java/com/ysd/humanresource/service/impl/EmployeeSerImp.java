package com.ysd.humanresource.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.EmployeeMapper;
import com.ysd.humanresource.entity.Employee;
import com.ysd.humanresource.entity.Fenye;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.entity.SalaryStandard;
import com.ysd.humanresource.service.EmployeeSer;

@Service
public class EmployeeSerImp implements EmployeeSer {
	@Autowired
	private EmployeeMapper empmap;
	
	@Override
	public Fenye<Employee> empFenye(Fenye<Employee> fenye) {
		// TODO Auto-generated method stub
			List<Employee> rows=empmap.empFenye(fenye);
			Integer total=empmap.empCon(fenye);
			fenye.setTotal(total);
			fenye.setRows(rows);
		return fenye;
	}

	@Override
	public List<Position> selPos() {
		// TODO Auto-generated method stub
		return empmap.selPos();
	}

	@Override
	public Integer AddUser(Employee employee) {
		// TODO Auto-generated method stub
		
	    Date date = new Date();
	    String str = "yyyMMdd";
	    SimpleDateFormat sdf = new SimpleDateFormat(str);
	    String t=sdf.format(date);
	    int d=(int)((Math.random()*9+1)*1000);
	    String td=t+d;

	    employee.setEmp_fileNumber(td);
	    System.out.println(employee);

		return empmap.AddUser(employee);
	}

	@Override
	public Integer empDel(String Id) { 
		// TODO Auto-generated method stub
		return empmap.empDel(Id);
	}

	@Override
	public Fenye<Employee> empBoss(Fenye<Employee> fenye) {
		// TODO Auto-generated method stub
		List<Employee> rows=empmap.empBoss(fenye);
		Integer total=empmap.empContwo(fenye);
		fenye.setTotal(total);
		fenye.setRows(rows);
		return fenye;
	}

	@Override
	public Integer upEmp(Employee employee) {
		// TODO Auto-generated method stub
		return empmap.upEmp(employee);
	}


}
