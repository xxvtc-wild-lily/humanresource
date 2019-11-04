package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
//调动记录表
public class TransFerrecord {
	private Integer tf_id;	//调动记录id
	private String tf_fileNumber;	//档案编号
	private Integer emp_id;	//员工id
	private String tf_originalDepartment;	//原部门名称
	private String tf_originalPosition;	//原岗位名称
	private String tf_originalSalaryStandard;	//原薪酬标准
	private String tf_newDepartment;	//新部门名称
	private String tf_newPosition;	//新岗位名称
	private String tf_newSalaryStandard;	//新薪酬标准
	private String tf_registrant;	//登记人
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date tf_registrationTime;	//登记时间
	private String tf_mobilizingReason;	//调动原因
	private String tf_auditor;	//审核人
	@DateTimeFormat(pattern = "yyyy-MM-hh")
	private Date tf_auditTime;	//审核时间
	private String tf_auditOpinion;	//审核意见
	private Integer tf_auditStatus;	//审核状态

}
