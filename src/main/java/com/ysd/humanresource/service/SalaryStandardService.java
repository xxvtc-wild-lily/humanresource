package com.ysd.humanresource.service;

import java.util.List;

import com.ysd.humanresource.entity.Pagination;
import com.ysd.humanresource.entity.SalaryStandard;

public interface SalaryStandardService {
	
	/**
	 * ���н���׼
	 * @param salaryStandard ����н���׼��Ϣ��ʵ����
	 * @return ��Ӱ�������
	 */
	Integer insertSalaryStandard(SalaryStandard salaryStandard);
	
	/**
	 * ����н�����Ʋ��Ҹ�н���׼�Ƿ����
	 * @param salaryStandard ����н���׼��Ϣ��ʵ����
	 * @return ��ѯ���ķ�������������
	 */
	Integer selectCountBySalaryStandardName(SalaryStandard salaryStandard);
	
	/**
	 * ��ѯδ��˵�н���׼
	 * @param pagination ������ҳ��Ϣ��ʵ����
	 * @return ��ѯ����δ��˵�н����Ϣ
	 */
	Pagination<SalaryStandard> selectAllUncheckSalaryStandard(Pagination<SalaryStandard> pagination);
	
	/**
	 * ����н�����ƺ�id���Ҹ�н���׼�Ƿ����
	 * @param salaryStandard ����н���׼��Ϣ��ʵ����
	 * @return ��ѯ���ķ�������������
	 */
	Integer selectCountBySalaryStandardNameAndId(SalaryStandard salaryStandard);
	
	/**
	 * ͨ��н���׼��˺����id�޸�н���׼
	 * @param salaryStandard ����н���׼��Ϣ��ʵ����
	 * @return ��Ӱ�������
	 */
	Integer updateSalaryStandardById(SalaryStandard salaryStandard);
	
	/**
	 * ��ѯ����ͨ����˵�н���׼
	 * @param pagination ������ҳ��Ϣ��ʵ����
	 * @return ��ѯ����ͨ����˵�н���׼
	 */
	Pagination<SalaryStandard> selectAllCheckedSalaryStandard(Pagination<SalaryStandard> pagination);
	
}
