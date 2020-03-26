package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.User;
import com.ye.service.StudentService;

@Controller
@RequestMapping("/student/")
public class StudentController {
	@Resource
	private StudentService studentServiceImpl;
	
	@RequestMapping("showStuInfo")
	@ResponseBody
	public User showStuInfo(HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		return studentServiceImpl.findStuInfo(user.getId());
		
	}
}
