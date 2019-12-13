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
	 * 连表分页查询简历和成绩
	 * @param pag
	 * @return
	 */
	public Pagination<InterviewAudit> selectInterviewAuditAndResumes(Pagination<InterviewAudit> pag);
	/**
	 * 面试筛选修改面试状态
	 * @param inte
	 * @return
	 */
	public Integer updateInterviewAudit(InterviewAudit inte);
	/**
	 * 根据简历ID删除简历
	 * @param re_id
	 * @return
	 */
	public Integer deleteResume(Integer re_id);
	/**
	 * 查询需要人事经理录用审核的简历和面试审核信息
	 * @param pag
	 * @return
	 */
	public Pagination<InterviewAudit> selectResumeAndInterviewAudit(Pagination<InterviewAudit> pag);
	/**
	 * 录用审核不通过
	 * @param re_id
	 * @return
	 */
	public Integer luYongShenHeBuTongGuo(Integer re_id);
}
