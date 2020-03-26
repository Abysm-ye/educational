package com.ye.service;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Student;
import com.ye.pojo.User;

public interface StudentManageService {
	/**
	 * 查询所有学生用户信息
	 * @return
	 */
	public EasyUIDatagrid findStudent(int rows,int page);
	
	/**
	 * 添加学生用户
	 * @param student
	 * @return
	 */
	public ResultInfo addStudentUser(Student student);
	
	/**
	 * 根据用户id删除用户信息
	 * @param ids
	 * @return
	 */
	public ResultInfo delStudentUser(int[] ids);
	
	/**
	 * 通过用户id查询该用户所有信息
	 * @param id
	 * @return
	 */
	public User findStudentUser(int id);
	
	/**
	 * 修改学生用户信息
	 * @param stu
	 * @return
	 */
	public ResultInfo editStudentUser(Student stu);
}
