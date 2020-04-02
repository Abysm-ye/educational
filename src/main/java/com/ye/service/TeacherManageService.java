package com.ye.service;

import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;

public interface TeacherManageService {
	/**
	 * 添加教师用户
	 * @param user
	 * @return
	 */
	public ResultInfo addTeaUser(User user);
	
	/**
	 * 分页查询教师用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIDatagrid findByPage(int page,int rows);

	/**
	 * 删除教师用户信息（支持批量删除）
	 * @param ids
	 * @return
	 */
	public ResultInfo delTeaUser(int[] ids);
	
	/**
	 * 修改时回显数据
	 * @param id
	 * @return
	 */
	public User echoData(int id);
	
	/**
	 * 修改教师用户信息
	 * @param user
	 * @return
	 */
	public ResultInfo editTeaUser(User user);
}
