package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
public interface InterviewAuditMapper {
	/**
	 * 连表分页查询简历和面试登记表
	 * @param pag
	 * @return
	 */
	public List<InterviewAudit> selectResumeInterviewAudit(Pagination<InterviewAudit> pag);
	/**
	 * 连表分页查询简历和面试登记表总条数
	 * @param pag
	 * @return
	 */
	public Integer selectResumeInterviewAuditCount(Pagination<InterviewAudit> pag);
	/**
	 * 分页连表查询需要审核的简历和面试登记表信息
	 * @param pag
	 * @return
	 */
	public List<InterviewAudit> selectResumeAndInterviewAudit(Pagination<InterviewAudit> pag);
	/**
	 * 分页连表查询需要审核的简历和面试登记表信息总条数
	 * @param pag
	 * @return
	 */
	public Integer selectResumeAndInterviewAuditCount(Pagination<InterviewAudit> pag);
	/**
	 * 根据简历ID修改面试状态
	 * @param inte
	 * @return
	 */
	public Integer updateInterviewAuditByReId(InterviewAudit inte);
	/**
	 * 根据简历ID删除面试登记信息
	 * @param re_id
	 * @return
	 */
	public Integer deleteInterviewAuditByReId(Integer re_id);
	/**
	 * 根据简历ID删除简历
	 * @param re_id
	 * @return
	 */
	public Integer deleteResumeByReId(Integer re_id);
	/**
	 * 录用审核不通过
	 * @param re_id
	 * @return
	 */
	public Integer shenHeBuTongGuo(Integer re_id);
	
}
