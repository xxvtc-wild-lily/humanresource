package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.RecruItmentinfo;
import com.ysd.humanresource.service.RecrultmentinfoService;

@RestController
public class RecrultmentinfoController {
	@Autowired
	private RecrultmentinfoService recser;
	@PostMapping("/addrecru")
	public Integer addRecrultmentinfo(RecruItmentinfo rec) {
		
		Integer addRecrultmentinfo = recser.addRecrultmentinfo(rec);
		return addRecrultmentinfo;
	}
	@PostMapping("/selectrecitm")
	public Pagination<RecruItmentinfo> selectRecItm(@RequestParam("rows") Integer pageSize,Pagination<RecruItmentinfo> pa){
		pa.setPageSize(pageSize);
		pa.setPage((pa.getPage()-1)*pa.getPageSize());
		Pagination<RecruItmentinfo> selectRecruItmentinfo = recser.selectRecruItmentinfo(pa);
		return selectRecruItmentinfo;
	}
	@PostMapping("/deleterecitm")
	public Integer deleteRecItm(Integer ri_id) {
		Integer deleteRecruItmentinfoById = recser.deleteRecruItmentinfoById(ri_id);
		return deleteRecruItmentinfoById;
		
	}
	@PostMapping("/updaterecitm")
	public Integer updateRecItm(RecruItmentinfo re) {
		Integer updateRecruItmentinfoById = recser.updateRecruItmentinfoById(re);
		return updateRecruItmentinfoById;
		
	}
}
