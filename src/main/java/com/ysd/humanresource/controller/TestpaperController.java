package com.ysd.humanresource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ysd.humanresource.entity.TestPaper;
import com.ysd.humanresource.service.TestpaperService;

@RestController
public class TestpaperController {
	@Autowired
	private TestpaperService testpaperservice;
	
	@PostMapping("/defen")
	public Integer kaoShiFenShu(String daans) {
		
		Integer chengji = testpaperservice.kaoShi(daans);
		return chengji;
		
	}
}
