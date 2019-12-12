package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ysd.humanresource.dao.TestpaperMapper;
import com.ysd.humanresource.entity.InterviewAudit;
import com.ysd.humanresource.entity.Resume;
import com.ysd.humanresource.entity.TestPaper;
import com.ysd.humanresource.entity.TestQuestion;
import com.ysd.humanresource.service.TestpaperService;
@Service
public class TestpaperServiceImpl implements TestpaperService {
	@Autowired
	private TestpaperMapper testpapermapper;
	@Override
	public Integer kaoShi(String daans) {
		Gson gson = new Gson();
		List<TestPaper> list = gson.fromJson(daans, new TypeToken<List<TestPaper>>(){}.getType());
		Integer chengji=0;
		for(int i=0;i<list.size();i++) {
			Integer kaoShi = testpapermapper.tianJiaShiJian(list.get(i));
		}
		for(int i=0;i<list.size();i++) {
			 TestQuestion zhengQunDanAn = testpapermapper.zhengQunDanAn(list.get(i).getTp_testQuestionId());
			
			 if(zhengQunDanAn.getTq_correctAnswer().equals(list.get(i).getTp_answer())) {
				chengji+=5;
			}
		}
		Resume resume=new Resume();
		resume.setRe_id(list.get(0).getTp_resumeId());
		resume.setRe_matchTestResult(chengji);
		Integer xuiGaiChengJi = testpapermapper.xuiGaiChengJi(resume);
		Integer xuiGaiMianShiZhuangTai = testpapermapper.xuiGaiMianShiZhuangTai(list.get(0).getTp_resumeId());
 		return chengji;
	}

}
