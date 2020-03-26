package com.ye.service;

import javax.servlet.http.HttpSession;

import com.ye.pojo.EasyUIDatagrid;

public interface RegisterInfoService {
	/**
	 * 根据uid分页查询
	 * @param uid
	 * @param pageStart
	 * @param pageSize
	 * @return
	 */
	public EasyUIDatagrid selByPage(int pageStart,int pageSize,HttpSession session);
}
