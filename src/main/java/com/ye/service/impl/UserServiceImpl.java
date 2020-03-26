package com.ye.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ye.mapper.UserMapper;
import com.ye.pojo.User;
import com.ye.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		return userMapper.selByUser(user);
	}
	
	@Override
	public int editPwd(String oldPwd,String newPwd, int uid) {
		
		return userMapper.updByUid(oldPwd,newPwd, uid);
	}

}
