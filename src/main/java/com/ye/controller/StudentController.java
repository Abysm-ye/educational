package com.ye.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
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
	
	@RequestMapping("stuCourseList")
	@ResponseBody
	public EasyUIDatagrid findStuCourse(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,HttpSession session) {
		//获取session中user信息
		User user = (User)session.getAttribute("user");
		
		return studentServiceImpl.findStuCourse(page, rows, user.getId());
	}
	
	@RequestMapping("selCourseList")
	@ResponseBody
	public EasyUIDatagrid findElective(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows) {
		
		return studentServiceImpl.findElective(page, rows);
	}
	
	
	@RequestMapping("addCourse")
	@ResponseBody
	public ResultInfo addCourse(int courseId,HttpSession session) {
		//获取session中user信息
		User user = (User)session.getAttribute("user");
		
		return studentServiceImpl.addCourse(courseId, user.getId());
	}
	
	@RequestMapping("showScore")
	@ResponseBody
	public EasyUIDatagrid findScore(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		return studentServiceImpl.findScore(page, rows, user.getId());
	}
}
