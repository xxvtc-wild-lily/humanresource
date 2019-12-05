package com.ysd.humanresource.dao;
import java.util.List;

import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.Resume;
public interface ResumeMapper {
	/**
	 * 简历登记
	 * @param resume
	 * @return
	 */
	 public Integer inResume(Resume resume);
	 /**
	  * 根据姓名和手机号查询应聘的部门和岗位
	  * @return
	  */
	 public Resume selectByNameAndShouJiHao(Resume resume);
	 /**
	  * 多条件查询简历
	  * @param resume
	  * @return
	  */
	 public List<Resume> selectResumeByDuoTiaoJian(Pagination<Resume> pag);
	 /**
	  * 多条件查询简历总条数
	  * @param resume
	  * @return
	  */
	 
	 public Integer selectResumeByDuoTiaoJianCount(Pagination<Resume> pag);
	 /**
	  * 简历登记时添加面试登记表的状态
	  * @param re_id
	  * @return
	  */
	 public Integer interviewRegistration(Integer re_id);
	 /**
	  * 查询简历最大的简历ID
	  * @return
	  */
	 public Integer selectResumeMaxReid();
	 /**
	  * 面试结果登记
	  * @param ia
	  * @return
	  */
	 public Integer updateInterviewAudit(InterviewAudit ia);
}
