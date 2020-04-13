package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.User;
import com.ye.service.TeacherManageService;
import com.ye.service.TeacherService;

@Controller
@RequestMapping("/teacher/")
public class TeacherController {
	
	@Resource
	private TeacherManageService teacherManageServiceImpl;
	@Resource
	private TeacherService teacherServiceImpl;
	
	/*查询教师个人信息*/
	@RequestMapping("showTeaInfo")
	@ResponseBody
	public User findTeaUser(HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		return teacherManageServiceImpl.echoData(user.getId());
	}
	
	
	@RequestMapping("teaCourseList")
	@ResponseBody
	public EasyUIDatagrid findTeaCourse(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="1")int rows,HttpSession session) {
		User user=(User)session.getAttribute("user");
		
		return teacherServiceImpl.findTeaCourse(page, rows, user.getId());
	}
	
}
