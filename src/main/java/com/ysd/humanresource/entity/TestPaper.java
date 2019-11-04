package com.ysd.humanresource.entity;

import lombok.Data;

@Data
//试卷表
public class TestPaper {
	private Integer tp_resumeId;	//简历id
	private Integer tp_testQuestionId;	//试题id
	private String tp_answer;	//答案

}
