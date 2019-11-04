package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//账户表
public class Account {
	private Integer Acc_id;	//账户id
	private Integer Emp_id;	//员工id
	private String Acc_telPhone;	//登陆电话
	private String Acc_email;	//登陆邮箱
	private String Acc_password;	//账户密码
	private String Acc_salt;	//账户盐值
	private Integer Acc_passwordWrongTimes;	//账户错误次数
	private Integer Acc_lockStatus;	//账户锁定状态
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date Acc_lockTime;	//账户锁定时间

}
