package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.service.ResumeService;

@RestController
public class ResumeController {
	@Autowired
	private ResumeService resumeservice;
	@PostMapping("/addresume")
	public Integer addResume(Resume resume) {
		Integer addResume = resumeservice.addResume(resume);
		return addResume;
	}
	@PostMapping("/selectresume")
	public Pagination<Resume> selectResumeDuoTiaoJian(@RequestParam("rows") Integer pageSize,Pagination<Resume> pa){
		pa.setPageSize(pageSize);
		pa.setPage((pa.getPage()-1)*pa.getPageSize());
		Pagination<Resume> selectResume = resumeservice.selectResume(pa);
		return selectResume;
		
	}
	@PostMapping("/mianshidengji")
	public Integer MianShiDengJi(InterviewAudit ia) {
		Integer mianShiDengJi = resumeservice.MianShiDengJi(ia);
		return mianShiDengJi;
		
	}
}
