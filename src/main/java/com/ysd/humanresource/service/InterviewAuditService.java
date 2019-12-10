package com.ysd.humanresource.service;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;

public interface InterviewAuditService {
	/**
	 * 连表分页查询简历和面试登记表
	 * @param pag
	 * @return
	 */
	public Pagination<InterviewAudit> selectInterviewAuditAndResume(Pagination<InterviewAudit> pag);
	/**
	 * 面试筛选修改面试状态
	 * @param inte
	 * @return
	 */
	public Integer updateInterviewAudit(InterviewAudit inte);
}
