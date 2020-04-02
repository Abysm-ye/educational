package com.ye.service;


import com.ye.pojo.EasyUIDatagrid;

public interface RegisterInfoService {
	/**
	 * 根据用户ID查询学生注册信息
	 * @param uid
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public EasyUIDatagrid selStuRegInfoById(int page,int rows,int uid);
	
	/**
	 * 根据用户ID查询教师注册信息
	 * @param uid
	 * @return
	 */
	public EasyUIDatagrid selTeaRegInfoById(int id);
}
