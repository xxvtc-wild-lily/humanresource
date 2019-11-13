package com.ysd.humanresource.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class TransFerrecord {
	
	private Integer tf_id;
	private String tf_fileNumber;
	private Integer emp_id;
	private String tf_originalDepartment;
	private String tf_originalPosition;
	private String tf_originalSalaryStandard;
	private String tf_newDepartment;
	private String tf_newPosition;
	private String tf_newSalaryStandard;
	private String tf_registrant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tf_registrationTime;
	private String tf_mobilizingReason;
	private String tf_auditor;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tf_auditTime;
	private String tf_auditOpinion;
	private Integer tf_auditStatus;
	
}
