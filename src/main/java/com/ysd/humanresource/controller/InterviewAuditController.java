package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.service.InterviewAuditService;

@RestController
public class InterviewAuditController {
	@Autowired
	private InterviewAuditService interviewAuditService;
	@PostMapping("/selectInterviewAuditResume")
	public Pagination<InterviewAudit> selectInterviewAuditResume(@RequestParam("rows") Integer pageSize,Pagination<InterviewAudit> pag){
		pag.setPageSize(pageSize);
		pag.setPage((pag.getPage()-1)*pag.getPageSize());
		Pagination<InterviewAudit> selectInterviewAuditAndResume = interviewAuditService.selectInterviewAuditAndResume(pag);
		return selectInterviewAuditAndResume;
		
	}
	@PostMapping("/mianShiShaiXuan")
	public Integer mianShiShaiXuan(InterviewAudit inte) {
		Integer updateInterviewAudit = interviewAuditService.updateInterviewAudit(inte);
		return updateInterviewAudit;
		
	}
}
