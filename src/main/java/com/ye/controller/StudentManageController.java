package com.ye.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Student;
import com.ye.pojo.User;
import com.ye.service.StudentManageService;

@Controller
@RequestMapping("/admin/")
public class StudentManageController {
	@Resource
	private StudentManageService studentManageServiceImpl;
	
	/*//当前端页面传过来的的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}*/
	
	//学生列表
	@RequestMapping("stuList")
	@ResponseBody
	public EasyUIDatagrid studentList(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		
		return studentManageServiceImpl.findStudent(rows, page);
	}
	
	//添加学生
	@RequestMapping("addStudent")
	@ResponseBody
	public ResultInfo addStudentUser(Student student) {
		
		return studentManageServiceImpl.addStudentUser(student);
	}
	
	//删除学生
	@RequestMapping("delStudent")
	@ResponseBody
	public ResultInfo delStudentUser(@RequestParam("ids[]")int[] ids) {
		
		return studentManageServiceImpl.delStudentUser(ids);
	}
	
	//回显数据，方便用户修改信息
	@RequestMapping("stuEditUI")
	@ResponseBody
	public User findStudentUser(int id) {
		
		return studentManageServiceImpl.findStudentUser(id);
	}
	
	@RequestMapping("editStu")
	@ResponseBody
	//修改学生信息
	public ResultInfo editStudentUser(Student stu) {
		
		return studentManageServiceImpl.editStudentUser(stu);
	}
}
