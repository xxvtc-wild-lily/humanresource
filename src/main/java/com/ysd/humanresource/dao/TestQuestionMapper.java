package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestQuestion;

public interface TestQuestionMapper {
	/**
	 * 多条件查询试题
	 * @param pag
	 * @return
	 */
	public List<TestQuestion> selectTestQuestion(Pagination<TestQuestion> pag);
	/**
	 * 多条件查询试题总条数
	 * @param pag
	 * @return
	 */
	public Integer selectTestQuestionCount(Pagination<TestQuestion> pag);
	/**
	 * 添加试题
	 * @param tq
	 * @return
	 */
	public Integer addTestQuestionCount(TestQuestion tq);
	/**
	 * 根据部门和职位随机查询20套题
	 * @param resume
	 * @return
	 */
	public List<TestQuestion> selectTestQuestionByBuMenAndZhiWei(Resume resume);
}
