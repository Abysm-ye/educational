package com.ye.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ye.mapper.RegisterInfoMapper;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.User;
import com.ye.service.RegisterInfoService;

@Service
public class RegisterInfoServiceImpl implements RegisterInfoService{
	@Resource
	private RegisterInfoMapper registerInfoMapper;
	@Override
	public EasyUIDatagrid selByPage(int rows, int page,HttpSession session) {
		User user=(User)session.getAttribute("user");
		int uid = user.getId();
		int pageStart = rows*(page-1);
		EasyUIDatagrid data = new EasyUIDatagrid();
		data.setRows(registerInfoMapper.selByPage(uid, pageStart, rows));
		data.setTotal(registerInfoMapper.selTotal());
		return data;
	}

}
