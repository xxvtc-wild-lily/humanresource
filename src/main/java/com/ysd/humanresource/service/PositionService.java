package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Position;

public interface PositionService {
	/**
	 * 根据部门查询职位
	 * @param dep_id
	 * @return
	 */
	public List<Position> selectPosByDepid(Position de);
}
