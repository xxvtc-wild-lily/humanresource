package com.ysd.humanresource.entity;

import java.util.Date;

import lombok.Data;
@Data
//简历表
public class Resume {
	private Integer Re_id;	//简历id
	private String Re_recruitmentType;	//招聘类型
	private String Re_department;	//招聘部门
	private String Re_position;	//招聘职位
	private String Re_name;	//姓名
	private Integer Re_sex;	//性别
	private String Re_email;	//邮箱
	private String Re_telPhone;	//电话
	private String Re_address;	//住址
	private Integer Re_postalCode;	//邮编
	private String Re_nationality;	//国籍
	private String Re_birthAddress;	//出生地
	private Integer Re_age;	//年龄
	private Date Re_birthday;	//生日
	private String Re_nation;	//民族
	private String Re_faith;	//宗教信仰
	private String Re_politicalOutlook;	//政治面貌
	private String Re_IDnumber;	//身份证号
	private String Re_graduateSchool;	//毕业院校
	private String Re_qualifications;	//学历
	private Integer Re_yearsOfEducation;	//受教育年限
	private String Re_major;	//学历专业
	private String Re_salaryRequirement;	//薪酬要求
	private String Re_speciality;	//特长
	private String Re_hobby;	//爱好
	private String Re_personalResume;	//个人履历
	private String Re_remarks;	//备注
	private Date Re_registrationTime;	//登记时间
	private String Re_recommender;	//推荐人
	private Date Re_recommendedTime;	//推荐时间
	private String Re_recommendation;	//推荐意见
	private Integer Re_machineTestResult;	//机试成绩
	private Integer Re_WrittenTestResult;	//笔试成绩

}
