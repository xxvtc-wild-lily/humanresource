package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestQuestion;

public interface TestQuestionService {
	/**
	 * 多条件查询试题及试题数量
	 * @param pag
	 * @return
	 */
	public Pagination<TestQuestion> selectTestQuestion(Pagination<TestQuestion> pag);
	/**
	 * 添加试题
	 * @param tq
	 * @return
	 */
	public Integer addTestQuestion(TestQuestion tq);
	/**
	 * 考试
	 * @param resume
	 * @return
	 */
	public List kaoShi(Resume resume);
}
