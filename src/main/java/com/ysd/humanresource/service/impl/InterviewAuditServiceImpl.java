package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.InterviewAuditMapper;
import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.service.InterviewAuditService;
@Service
public class InterviewAuditServiceImpl implements InterviewAuditService {
	@Autowired
	private InterviewAuditMapper interviewAuditMapper;
	@Override
	public Pagination<InterviewAudit> selectInterviewAuditAndResume(Pagination<InterviewAudit> pag) {
		List<InterviewAudit> selectResumeInterviewAudit = interviewAuditMapper.selectResumeInterviewAudit(pag);
		Integer selectResumeInterviewAuditCount = interviewAuditMapper.selectResumeInterviewAuditCount(pag);
		pag.setRows(selectResumeInterviewAudit);
		pag.setTotal(selectResumeInterviewAuditCount);
		return pag;
	}
	@Override
	public Integer updateInterviewAudit(InterviewAudit inte) {
		Integer updateInterviewAuditByReId = interviewAuditMapper.updateInterviewAuditByReId(inte);
		return updateInterviewAuditByReId;
	}

}
