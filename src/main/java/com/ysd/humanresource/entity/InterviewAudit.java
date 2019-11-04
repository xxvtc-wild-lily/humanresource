package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//面试审核表
public class InterviewAudit {
	private Integer ia_id;	//面试审核id
	private Integer ia_interviewTimes;	//面试次数
	private String ia_imageEvaluation;	//形象评价
	private String ia_eloquenceEvaluation;	//口才评价
	private String ia_oralEnglishAbility;	//外语口语评价
	private String ia_strainCapacity;	//应变能力
	private String ia_EQ;	//EQ
	private String ia_IQ;	//IQ
	private String ia_comprehensiveQuality;	//综合素质
	private String ia_interviewer;	//面试人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ia_interviewTime;	//面试时间
	private String ia_interviewEvaluation;	//面试评价
	private Integer ia_interviewOpinion;	//面试意见
	private String ia_screeningPeople;	//筛选人
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ia_screeningTime;	//筛选时间
	private String ia_employmentApplicationComment;	//录用申请意见

}
