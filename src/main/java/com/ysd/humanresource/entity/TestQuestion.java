package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class TestQuestion {
	
	private Integer tq_id;
	private String tq_department;
	private String tq_positon;
	private String tq_registrant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tq_registrationTime;
	private Integer tq_type;
	private String tq_stem;
	private String tq_answerA;
	private String tq_answerB;
	private String tq_answerC;
	private String tq_answerD;
	private String tq_answerE;
	private String tq_correctAnswer;
	
}
