package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.User;
import com.ye.service.RegisterInfoService;

@Controller
public class RegisterInfoController {
	@Resource
	private RegisterInfoService registerInfoServiceImpl;
	
	@RequestMapping("/stuRegInfo")
	@ResponseBody
	public EasyUIDatagrid findStuRegInfo(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,HttpSession session) {
		
		/*获取session中用户ID*/
		User user = (User)session.getAttribute("user");
		
		return registerInfoServiceImpl.selStuRegInfoById(page,rows,user.getId());
	}
	
	@RequestMapping("/teaRegInfo")
	@ResponseBody
	public EasyUIDatagrid findTeaRegInfo(HttpSession session) {
		/*获取session中用户ID*/
		User user = (User)session.getAttribute("user");
		
		return registerInfoServiceImpl.selTeaRegInfoById(user.getId());
	}
}
