package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Employee {
	
	private Integer emp_id;
	private String emp_fileNumber;
	private String emp_name;
	private Integer emp_sex;
	private String emp_picture;
	private String emp_email;
	private String emp_telPhone;
	private String emp_address;
	private Integer emp_postalCode;
	private String emp_nationality;
	private String emp_birthAddress;
	private Integer emp_age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emp_birthday;
	private String emp_nation;
	private String emp_faith;
	private String emp_politicalOutlook;
	private String emp_IDnumber;
	private String emp_socialSecurityNumber;
	private String emp_graduateSchool;
	private String emp_qualifications;
	private Integer emp_yearsOfEducation;
	private String emp_major;
	private String emp_openingBank;
	private String emp_bankAccount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emp_registrantTime;
	private String emp_speciality;
	private String emp_hobby;
	private String emp_personalResume;
	private String emp_familyRelationsInfo;
	private Integer emp_registrant;
	private Integer pos_id;
	private String emp_remarks;
	
	private Position position;
}
