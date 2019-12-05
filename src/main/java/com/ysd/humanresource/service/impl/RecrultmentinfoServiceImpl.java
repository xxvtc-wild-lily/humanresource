package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.RecrultmentinfoMapper;
import com.ysd.humanresource.entity.Pagination;
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
	@Override
	public Pagination<RecruItmentinfo> selectRecruItmentinfo(Pagination<RecruItmentinfo> pa) {
		List<RecruItmentinfo> selectRecruItmentionfo = recmap.selectRecruItmentionfo(pa);
		Integer selectRecruItmentionfoCount = recmap.selectRecruItmentionfoCount(pa);
		pa.setRows(selectRecruItmentionfo);
		pa.setTotal(selectRecruItmentionfoCount);
		return pa;
	}
	@Override
	public Integer deleteRecruItmentinfoById(Integer ri_id) {
		Integer delectRecruItmentionfoById = recmap.delectRecruItmentionfoById(ri_id);
		return delectRecruItmentionfoById;
	}
	@Override
	public Integer updateRecruItmentinfoById(RecruItmentinfo re) {
		Integer updateRecruItmentionfoById = recmap.updateRecruItmentionfoById(re);
		return updateRecruItmentionfoById;
	}

}
