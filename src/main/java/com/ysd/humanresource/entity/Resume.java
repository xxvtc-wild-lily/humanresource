package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Resume {
	
	private Integer re_id;
	private String re_recruitmentType;
	private String re_department;
	private String re_position;
	private String re_name;
	private Integer re_sex;
	private String re_email;
	private String re_telPhone;
	private String re_address;
	private Integer re_postalCode;
	private String re_nationality;
	private String re_birthAddress;
	private Integer re_age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date re_birthday;
	private String re_nation;
	private String re_faith;
	private String re_politicalOutlook;
	private String re_IDnumber;
	private String re_graduateSchool;
	private String re_qualifications;
	private Integer re_yearsOfEducation;
	private String re_major;
	private String re_salaryRequirement;
	private String re_speciality;
	private String re_hobby;
	private String re_personalResume;
	private String re_remarks;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date re_registrationTime;
	private String re_recommender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date re_recommendedTime;
	private String re_recommendation;
	private Integer re_matchTestResult;
	private Integer re_WrittenTestResult;
	
}
