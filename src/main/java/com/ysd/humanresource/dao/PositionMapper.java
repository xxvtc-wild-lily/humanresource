package com.ysd.humanresource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.humanresource.entity.Position;

public interface PositionMapper {
	/**
	 * 根据部门查询职位
	 * @return
	 */
	List<Position> selectPosByDepId(Position pos);
	/**
	 * 根据职位名称查询职位id
	 * @param posname
	 * @return
	 */
	Integer selectPosID(@Param("posname")String posname);
	/**
	 * 根据员工姓名查询员工id
	 * @param empname
	 * @return
	 */
	Integer selectEmpIdByName(@Param("empname")String empname);
	
}
