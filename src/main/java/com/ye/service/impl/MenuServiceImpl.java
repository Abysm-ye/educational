package com.ye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ye.mapper.MenuMapper;
import com.ye.pojo.Menu;
import com.ye.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> findMenu(int pid) {
		return menuMapper.selByPid(pid);
	}
	
}
