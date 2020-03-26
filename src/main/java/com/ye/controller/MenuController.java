package com.ye.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.Menu;
import com.ye.service.MenuService;

@Controller
public class MenuController {
	@Resource
	private MenuService menuServiceImpl;
	@RequestMapping("/showMenu")
	@ResponseBody
	public List<Menu> findMenu(int pid){
		return menuServiceImpl.findMenu(pid);
	}
}
