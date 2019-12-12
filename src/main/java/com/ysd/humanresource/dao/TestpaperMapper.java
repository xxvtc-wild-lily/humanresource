package com.ysd.humanresource.dao;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestPaper;
import com.ysd.humanresource.entity.TestQuestion;

public interface TestpaperMapper {
	/**
	 * 将面试者考试的题添加到试卷表中
	 * @param testpaper
	 * @return
	 */
	public Integer tianJiaShiJian(TestPaper testpaper);
	/**
	 * 根据试题ID查询正确答案
	 * @param te_id
	 * @return
	 */
	public TestQuestion  zhengQunDanAn(Integer te_id);
	/**
	 * 根据简历ID修改成绩
	 * @param resume
	 * @return
	 */
	public Integer xuiGaiChengJi(Resume resume);
	/**
	 * 根据简历ID修改面试意见
	 * @param ia
	 * @return
	 */
	public Integer xuiGaiMianShiZhuangTai(Integer ia);
}
