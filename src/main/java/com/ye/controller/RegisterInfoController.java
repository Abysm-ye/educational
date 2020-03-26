package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.service.RegisterInfoService;

@Controller
public class RegisterInfoController {
	@Resource
	private RegisterInfoService registerInfoServiceImpl;
	@RequestMapping("/regInfo")
	@ResponseBody
	public EasyUIDatagrid findRegInfo(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page,HttpSession session) {
		return registerInfoServiceImpl.selByPage(rows,page,session);
	}
}
