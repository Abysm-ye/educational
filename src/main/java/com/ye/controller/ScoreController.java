package com.ye.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ye.dto.ComboxInfo;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Score;
import com.ye.pojo.User;
import com.ye.service.ScoreService;

@Controller
@RequestMapping("/score/")
public class ScoreController {
	
	@Resource
	public ScoreService scoreServiceImpl;
	
	/*展示课程下拉框*/
	@RequestMapping("showCourse")
	@ResponseBody
	public List<ComboxInfo> showCourse(HttpSession session){
		User user=(User)session.getAttribute("user");
		
		return scoreServiceImpl.findCourseName(user.getId());
	}
	
	/*展示学生下拉框*/
	@RequestMapping("showStudent")
	@ResponseBody
	public List<ComboxInfo> showStudent(HttpSession session){
		User user=(User)session.getAttribute("user");
		
		return scoreServiceImpl.findStuName(user.getId());
	}
	
	/*展示学生成绩*/
	@RequestMapping("showScore")
	@ResponseBody
	public EasyUIDatagrid showScore(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		return scoreServiceImpl.findScore(page, rows, user.getId());
	}
	
	/*新加学生成绩*/
	@RequestMapping("addScore")
	@ResponseBody
	public ResultInfo addScore(Score score) {
		
		return scoreServiceImpl.addScore(score);
	}
	
	//修改学生成绩
	@RequestMapping("editScore")
	@ResponseBody
	public ResultInfo editScore(double score,String remark,int id) {
		
		return scoreServiceImpl.editScore(score,remark, id);
	}
	
	//修改学生成绩
	@RequestMapping("delScore")
	@ResponseBody
	public ResultInfo delScore(@RequestParam("ids[]")int[] ids) {
		
		return scoreServiceImpl.delScore(ids);
	}
}
