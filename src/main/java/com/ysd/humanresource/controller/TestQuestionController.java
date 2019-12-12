package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestQuestion;
import com.ysd.humanresource.service.TestQuestionService;

@RestController
public class TestQuestionController {
	@Autowired
	private TestQuestionService tqs;
	@PostMapping("/selectTestQuestion")
	public Pagination<TestQuestion> seleteTestQuestion(@RequestParam("rows") Integer pageSize,Pagination<TestQuestion> pag){
		pag.setPageSize(pageSize);
		pag.setPage((pag.getPage()-1)*pag.getPageSize());
		Pagination<TestQuestion> selectTestQuestion = tqs.selectTestQuestion(pag);
		return selectTestQuestion;
	}
	@PostMapping("/addtestquestion")
	public Integer addTestQuestion(TestQuestion tq) {
		Integer addTestQuestion = tqs.addTestQuestion(tq);
		return addTestQuestion;
		
	}
	@PostMapping("/kaoshi")
	public List kaoShi(Resume resume) {
		List kaoShi = tqs.kaoShi(resume);
		return kaoShi;
		
	}
}
