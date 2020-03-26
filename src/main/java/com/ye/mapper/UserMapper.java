package com.ye.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ye.pojo.User;

public interface UserMapper {
	@Select("select * from user where account=#{account} and password=#{password} and rid=#{rid}")
	public User selByUser(User user);
	
	@Update("update user set password=#{arg1} where id=#{arg2} and password=#{arg0}")
	public int updByUid(String oldPwd,String newPwd,int uid);
}
