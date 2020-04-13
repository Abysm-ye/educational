package com.ye.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.dto.ComboxInfo;
import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;
import com.ye.service.CourseManageService;

@Controller
@RequestMapping("/course/")
public class CourseManageController {
	
	@Resource
	private CourseManageService courseManageServiceImpl;
	
	/*easyUI中combox组件数据*/
	@RequestMapping("showTea")
	@ResponseBody
	public List<ComboxInfo> findTeacher(){
		List<User> userList = courseManageServiceImpl.findTeaIdAndName();
		
		//封装easyUI combox组件需要的数据格式
		List<ComboxInfo> list=new ArrayList<>();
		for(User user:userList) {
			ComboxInfo info = new ComboxInfo();
			info.setId(user.getTeacher().getId());
			info.setText(user.getName());
			
			list.add(info);
		}
		
		return list;
	}
	
	/*添加新的课程*/
	@RequestMapping("addCourse")
	@ResponseBody
	public ResultInfo addCourse(Course course,int tid) {
		return courseManageServiceImpl.addCourse(course, tid);
	}
	
	/*课程列表*/
	@RequestMapping("courseList")
	@ResponseBody
	public EasyUIDatagrid findAll(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows) {
		
		return courseManageServiceImpl.findAll(page, rows);
	}
	
	/*删除课程信息*/
	@RequestMapping("delCourse")
	@ResponseBody
	public ResultInfo delTeaUser(@RequestParam("ids[]")int[] ids) {
		
		return courseManageServiceImpl.delCourse(ids);
	}
	
	/*修改课程信息*/
	@RequestMapping("editCourse")
	@ResponseBody
	public ResultInfo editCourse(Course course) {
		
		
		return courseManageServiceImpl.editCourse(course);
	}
}
