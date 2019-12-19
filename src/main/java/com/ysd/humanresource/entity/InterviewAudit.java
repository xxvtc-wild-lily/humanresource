package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class InterviewAudit {
	
	private Integer ia_id;
	private Integer ia_interviewTimes;
	private String ia_imageEvaluation;
	private String ia_eloquenceEvaluation;
	private String ia_oraEnglishAbility;
	private String ia_strainCapacity;
	private String ia_EQ;
	private String ia_IQ;
	private String ia_comprehensiveQuality;
	private String ia_interviewer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ia_interviewTime;
	private String ia_interviewEvaluation;
	private Integer ia_interviewOpinion;
	private String ia_screeningPeople;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ia_screeningTime;
	private String ia_employmentApplicationComment;
	private Integer re_id;
	private Resume resume;
	
	
}
