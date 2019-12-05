package com.ysd.humanresource.service;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.RecruItmentinfo;

public interface RecrultmentinfoService {
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
	public Pagination<RecruItmentinfo> selectRecruItmentinfo(Pagination<RecruItmentinfo> pa);
	/**
	 * 根据id删除招聘信息
	 * @param ri_id
	 * @return
	 */
	public Integer deleteRecruItmentinfoById(Integer ri_id);
	/**
	 * 根据id修改招聘信息
	 * @param re
	 * @return
	 */
	public Integer updateRecruItmentinfoById(RecruItmentinfo re);
}
