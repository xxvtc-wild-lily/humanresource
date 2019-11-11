package com.ysd.humanresource.dao;

import java.util.List;
import com.ysd.humanresource.entity.Position;

public interface PositionMapper {
	/**
	 * 根据部门查询职位
	 * @return
	 */
	List<Position> selectPosByDepId(Position pos);
}
