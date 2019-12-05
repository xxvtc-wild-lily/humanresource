package com.ysd.humanresource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.ResumeMapper;
import com.ysd.humanresource.dao.TestQuestionMapper;
import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestQuestion;
import com.ysd.humanresource.service.ResumeService;
@Service
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeMapper resumemapper;
	@Autowired
	private TestQuestionMapper testquestionmapper;
	@Override
	public Integer addResume(Resume resume) {
		Integer inResume = resumemapper.inResume(resume);
		Integer selectResumeMaxReid = resumemapper.selectResumeMaxReid();
		Integer i=resumemapper.interviewRegistration(selectResumeMaxReid);
		return inResume;
	}
	@Override
	public List selectByNameAndShouJi(Resume resume) {
		Resume selectByNameAndShouJiHao = resumemapper.selectByNameAndShouJiHao(resume);
		List list=new  ArrayList();
		if(selectByNameAndShouJiHao.getRe_id()!=null) {
			
			List<TestQuestion> selectTestQuestionByBuMenAndZhiWei = testquestionmapper.selectTestQuestionByBuMenAndZhiWei(resume);
			list.add(1);
			return list;
		}else {
			list.add(0);
			return list;
		}
		
	}
	@Override
	public Pagination<Resume> selectResume(Pagination<Resume> pag) {
		List<Resume> selectResumeByDuoTiaoJian = resumemapper.selectResumeByDuoTiaoJian(pag);
		Integer selectResumeByDuoTiaoJianCount = resumemapper.selectResumeByDuoTiaoJianCount(pag);
		pag.setRows(selectResumeByDuoTiaoJian);
		pag.setTotal(selectResumeByDuoTiaoJianCount);
		// TODO Auto-generated method stub
		return pag;
	}
	@Override
	public Integer MianShiDengJi(InterviewAudit ia) {
		// TODO Auto-generated method stub
		Integer interviewRegistration = resumemapper.updateInterviewAudit(ia);
		return interviewRegistration;
	}

}
