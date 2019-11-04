package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//面试题表
public class TestQuestion {
	private Integer tq_id;	//试题id
	private String tq_department;	//部门
	private String tq_positon;	//岗位
	private String tq_registrant;	//登记人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tq_registrationTime;	//登记时间
	private Integer tq_type;	//试题类型
	private String tq_stem;	//题干
	private String tq_answerA;	//答案A
	private String tq_answerB;	//答案B
	private String tq_answerC;	//答案C
	private String tq_answerD;	//答案D
	private String tq_answerE;	//答案E
	private String tq_correctAnswer;	//正确答案

}
