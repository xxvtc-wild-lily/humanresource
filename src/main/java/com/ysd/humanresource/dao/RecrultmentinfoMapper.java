package com.ysd.humanresource.dao;

import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.RecruItmentinfo;

public interface RecrultmentinfoMapper {
	/**
	 * 添加招聘信息
	 * @param rf
	 * @return
	 */
	public Integer addRecrultmentinfo(RecruItmentinfo rf);
	/**
	 * 分页查询所有招聘信息
	 * @param pa
	 * @return
	 */
	public List<RecruItmentinfo> selectRecruItmentionfo(Pagination<RecruItmentinfo> pa);
	/**
	 * 分页查询所有招聘信息的总条数
	 * @param pa
	 * @return
	 */
	public Integer selectRecruItmentionfoCount(Pagination<RecruItmentinfo> pa);
	/**
	 * 根据id删除招聘信息
	 * @param ri_id
	 * @return
	 */
	public Integer delectRecruItmentionfoById(Integer ri_id);
	/**
	 * 根据ID修改招聘信息
	 * @param re
	 * @return
	 */
	public Integer updateRecruItmentionfoById(RecruItmentinfo re);
}
