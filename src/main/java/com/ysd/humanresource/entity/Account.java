package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Account {
	
	private Integer acc_id;
	private Integer emp_id;
	private String acc_telPhone;
	private String acc_email;
	private String acc_password;
	private String acc_salt;
	private Date acc_lastLoginTime;
	private Integer acc_passwordWrongTimes;
	private Integer acc_lockStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acc_lockTime;
	
	private Employee employee;
	private String emp_fileNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emp_registrantTime;
	
	private String dep_name;
	
	private String ss_name;
	
}
