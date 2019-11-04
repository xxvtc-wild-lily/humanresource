package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Account {
	
	private Integer Acc_id;
	private Integer Emp_id;
	private String Acc_telPhone;
	private String Acc_email;
	private String Acc_password;
	private String Acc_salt;
	private Integer Acc_passwordWrongTimes;
	private Integer Acc_lockStatus;
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date Acc_lockTime;
	
}
