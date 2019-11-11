package com.ysd.humanresource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.humanresource.dao.PositionMapper;
import com.ysd.humanresource.entity.Position;
import com.ysd.humanresource.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionMapper posmap;
	@Override
	public List<Position> selectPosByDepid(Position de) {
		List<Position> selectPosByDepId = posmap.selectPosByDepId(de);
		return selectPosByDepId;
	}

}
