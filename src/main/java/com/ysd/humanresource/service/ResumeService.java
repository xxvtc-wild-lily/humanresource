package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;

public interface ResumeService {
	/**
	 * 登记简历
	 * @param resume
	 * @return
	 */
	public Integer addResume(Resume resume);
	/**
	 * 根据姓名和手机号查询是否有该应聘者
	 * @param resume
	 * @return
	 */
	public List selectByNameAndShouJi(Resume resume);
	/**
	 * 分页多条件查询简历
	 * @param pag
	 * @return
	 */
	public Pagination<Resume> selectResume(Pagination<Resume> pag);
	/**
	 * 面试登记
	 * @param ia
	 * @return
	 */
	public Integer MianShiDengJi(InterviewAudit ia);
}
