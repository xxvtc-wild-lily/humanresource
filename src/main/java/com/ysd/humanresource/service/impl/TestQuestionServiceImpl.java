package com.ysd.humanresource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.ResumeMapper;
import com.ysd.humanresource.dao.TestQuestionMapper;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestQuestion;
import com.ysd.humanresource.service.TestQuestionService;
@Service
public class TestQuestionServiceImpl implements TestQuestionService {
	@Autowired
	private TestQuestionMapper tqm;
	@Autowired
	private ResumeMapper res;
	@Override
	public Pagination<TestQuestion> selectTestQuestion(Pagination<TestQuestion> pag) {
		List<TestQuestion> selectTestQuestion = tqm.selectTestQuestion(pag);
		Integer selectTestQuestionCount = tqm.selectTestQuestionCount(pag);
		pag.setRows(selectTestQuestion);
		pag.setTotal(selectTestQuestionCount);
		return pag;
	}
	@Override
	public Integer addTestQuestion(TestQuestion tq) {
		Integer addTestQuestionCount = tqm.addTestQuestionCount(tq);
		return addTestQuestionCount;
	}
	@Override
	public List kaoShi(Resume resume) {
		List ss=new ArrayList();
		
		Resume selectByNameAndShouJiHao = res.selectByNameAndShouJiHao(resume);
		System.out.println(selectByNameAndShouJiHao);
		if(selectByNameAndShouJiHao==null) {
			return ss;
		}else {
			ss.add(resume.getRe_name());
			ss.add(resume.getRe_telPhone());
			resume.setRe_department(selectByNameAndShouJiHao.getRe_department());
			resume.setRe_position(selectByNameAndShouJiHao.getRe_position());
			List<TestQuestion> selectTestQuestionByBuMenAndZhiWei = tqm.selectTestQuestionByBuMenAndZhiWei(resume);
			ss.add(selectByNameAndShouJiHao.getRe_id());
			ss.add(selectByNameAndShouJiHao.getRe_department());
			ss.add(selectByNameAndShouJiHao.getRe_position());
			int p=selectTestQuestionByBuMenAndZhiWei.size();
			if(selectTestQuestionByBuMenAndZhiWei==null) {
				p=0;
			}
			ss.add(selectTestQuestionByBuMenAndZhiWei);
			return ss;
		}
		
	}

}
