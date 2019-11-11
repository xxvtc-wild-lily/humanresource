package com.ysd.humanresource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.RecrultmentinfoMapper;
import com.ysd.humanresource.entity.RecruItmentinfo;
import com.ysd.humanresource.service.RecrultmentinfoService;
@Service
public class RecrultmentinfoServiceImpl implements RecrultmentinfoService {
	@Autowired
	private RecrultmentinfoMapper recmap;
	@Override
	public Integer addRecrultmentinfo(RecruItmentinfo rf) {
		Integer addRecrultmentinfo = recmap.addRecrultmentinfo(rf);
		return addRecrultmentinfo;
	}

}
