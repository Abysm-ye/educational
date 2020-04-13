package com.ye.service;

import java.util.List;

import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;

public interface CourseManageService {
	/**
	 * 查询授课老师ID
	 * @return
	 */
	public List<User> findTeaIdAndName();
	
	/**
	 * 新增课程信息
	 * @param course
	 * @param info
	 * @return
	 */
	public ResultInfo addCourse(Course course,int tid);
	
	/**
	 * 查询所有课程信息
	 * @return
	 */
	public EasyUIDatagrid findAll(int page,int rows);
	
	/**
	 * 删除课程信息（支持批量删除）
	 * @param ids
	 * @return
	 */
	public ResultInfo delCourse(int[] ids);
	
	/**
	 * 根据ID修改课程信息
	 * @param course
	 * @param tid
	 * @return
	 */
	public ResultInfo editCourse(Course course);
}
