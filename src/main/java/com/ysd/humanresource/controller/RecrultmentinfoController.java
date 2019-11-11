package com.ysd.humanresource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
