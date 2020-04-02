package com.ye.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;
import com.ye.service.TeacherManageService;

@Controller
@RequestMapping("/admin/")
public class TeacherManageController {
	@Resource
	private TeacherManageService teacherManageServiceImpl;
	
	/*添加教师用户*/
	@RequestMapping("addTeacher")
	@ResponseBody
	public ResultInfo addTeaUser(User user) {
		return teacherManageServiceImpl.addTeaUser(user);
	}
	
	/*查询所有教师用户信息*/
	@RequestMapping("teaList")
	@ResponseBody
	public EasyUIDatagrid findByPage(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows) {
		
		return teacherManageServiceImpl.findByPage(page, rows);
	}
	
	/*删除教师用户*/
	@RequestMapping("delTeacher")
	@ResponseBody
	public ResultInfo delTeaUser(@RequestParam("ids[]")int[] ids) {
		
		return teacherManageServiceImpl.delTeaUser(ids);
	}
	
	/*回显数据*/
	@RequestMapping("teaEditUI")
	@ResponseBody
	public User echoData(int id) {
		
		return teacherManageServiceImpl.echoData(id);
	}
	
	/*修改教师用户信息*/
	@RequestMapping("editTea")
	@ResponseBody
	public ResultInfo editTeaUser(User user) {
		
		return teacherManageServiceImpl.editTeaUser(user);
	}
}
