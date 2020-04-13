package com.ye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.mapper.CourseManageMapper;
import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.User;
import com.ye.service.CourseManageService;

@Service
public class CourseManageServiceImpl implements CourseManageService{

	@Resource
	private CourseManageMapper courseManageMapper;
	
	@Override
	public List<User> findTeaIdAndName() {
		return courseManageMapper.selTeaIdAndName();
	}

	@Override
	public ResultInfo addCourse(Course course, int tid) {
		
		int index=0;
		index = courseManageMapper.insCourse(course);
		if(index>0) {
			
			index += courseManageMapper.insCourserTeacher(tid);
		}
		ResultInfo info = new ResultInfo();
		if(index==2) {
			info.setFlag(true);
			info.setData("成功添加新的课程！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("新增课程失败，请联系维护人员！");
		
		return info;
	}

	@Override
	public EasyUIDatagrid findAll(int page,int rows) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		
		//查询全部
		List<Course> courseList=courseManageMapper.selAll();
		for(Course course:courseList) {
			course.setUsers(courseManageMapper.selTeaName(course.getId()));
		}
		
		//分页信息
		PageInfo<Course> pageInfo = new PageInfo<>(courseList);
		//将分页信息放到EasyUIDataGrid中
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
		
	}

	@Override
	public ResultInfo delCourse(int[] ids) {
		int index=courseManageMapper.delCourse(ids);
		//封装响应数据
		ResultInfo info = new ResultInfo();
		if(index>0) {
			info.setFlag(true);
			info.setData("数据删除成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("删除失败！请联系维护人员");
		return info;
	}

	@Override
	public ResultInfo editCourse(Course course) {
		
		int index=courseManageMapper.updCourse(course);
		
		ResultInfo info = new ResultInfo();
		if(index>0) {
			info.setFlag(true);
			info.setData("数据修改成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("修改失败！请联系维护人员");
		return info;
	}
	
}
