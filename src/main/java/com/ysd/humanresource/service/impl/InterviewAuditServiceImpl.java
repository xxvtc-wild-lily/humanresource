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
	@Override
	public Integer deleteResume(Integer re_id) {
		Integer deleteInterviewAuditByReId = interviewAuditMapper.deleteInterviewAuditByReId(re_id);
		Integer deleteResumeByReId = interviewAuditMapper.deleteResumeByReId(re_id);
		return deleteResumeByReId;
	}
	@Override
	public Pagination<InterviewAudit> selectResumeAndInterviewAudit(Pagination<InterviewAudit> pag) {
		List<InterviewAudit> selectResumeAndInterviewAudit = interviewAuditMapper.selectResumeAndInterviewAudit(pag);
		Integer selectResumeAndInterviewAuditCount = interviewAuditMapper.selectResumeAndInterviewAuditCount(pag);
		pag.setRows(selectResumeAndInterviewAudit);
		pag.setTotal(selectResumeAndInterviewAuditCount);
		return pag;
	}
	@Override
	public Integer luYongShenHeBuTongGuo(Integer re_id) {
		Integer shenHeBuTongGuo = interviewAuditMapper.shenHeBuTongGuo(re_id);
		return shenHeBuTongGuo;
	}

}
