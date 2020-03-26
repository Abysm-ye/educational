package com.ye.service;

import com.ye.pojo.User;

public interface UserService {
	/**
	 * 登录功能
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 根据用户ID修改密码
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	public int editPwd(String oldPwd,String newPwd,int uid);
}
