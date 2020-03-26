package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ye.pojo.Menu;

public interface MenuMapper {
	@Select("select * from menu where pid=#{0}")
	public List<Menu> selByPid(int pid);
	
}
