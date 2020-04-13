package com.ye.service;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;

public interface StudentService {
	/**
	 * 查询学生基本信息
	 * @param id
	 * @return
	 */
	public User findStuInfo(int id);
	
	/**
	 * 分页查询学生课表
	 * @param page
	 * @param rows
	 * @param uid
	 * @return
	 */
	public EasyUIDatagrid findStuCourse(int page,int rows,int uid);
	
	/**
	 * 查询所有选修课程
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIDatagrid findElective(int page,int rows);
	
	/**
	 * 学生选修课程
	 * @param courseId
	 * @param uid
	 * @return
	 */
	public ResultInfo addCourse(int courseId,int uid);
	
	/**
	 * 学生查看自己的课程成绩
	 * @param page
	 * @param rows
	 * @param uid
	 * @return
	 */
	public EasyUIDatagrid findScore(int page,int rows,int uid);
}
