package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.TestQuestionMapper;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.TestQuestion;
import com.ysd.humanresource.service.TestQuestionService;
@Service
public class TestQuestionServiceImpl implements TestQuestionService {
	@Autowired
	private TestQuestionMapper tqm;
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

}
