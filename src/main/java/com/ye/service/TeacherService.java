package com.ye.service;

import com.ye.pojo.EasyUIDatagrid;

public interface TeacherService {
	
	public EasyUIDatagrid findTeaCourse(int page,int rows,int uid);
}
