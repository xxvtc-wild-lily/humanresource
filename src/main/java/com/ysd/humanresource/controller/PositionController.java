package com.ysd.humanresource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.service.PositionService;

@RestController
public class PositionController {
	@Autowired
	private PositionService posser;
	@PostMapping("/selectpos")
	public List<Position> selectPosByDepid(Position de){
		
		List<Position> selectPosByDepid = posser.selectPosByDepid(de);
		
		return selectPosByDepid;	
	}
}
