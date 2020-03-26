package com.ye.service;

import java.util.List;

import com.ye.pojo.Menu;

public interface MenuService {
	public List<Menu> findMenu(int pid);
}
