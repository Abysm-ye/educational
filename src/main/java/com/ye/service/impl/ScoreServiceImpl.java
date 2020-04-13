package com.ye.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.dto.ComboxInfo;
import com.ye.mapper.ScoreMapper;
import com.ye.pojo.Course;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Score;
import com.ye.pojo.Student;
import com.ye.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	@Resource
	private ScoreMapper scoreMapper;
	
	@Override
	public List<ComboxInfo> findCourseName(int uid) {
		
		List<Course> courseList=scoreMapper.selCourseIdAndName(uid);
		
		List<ComboxInfo> list = new ArrayList<>();
		for(Course course:courseList) {
			ComboxInfo info = new ComboxInfo();
			info.setId(course.getId());
			info.setText(course.getName());
			
			list.add(info);
		}
		return list;
	}

	@Override
	public List<ComboxInfo> findStuName(int uid) {
		
		List<Student> stuList=scoreMapper.selStuIdAndName(uid);
		
		List<ComboxInfo> list = new ArrayList<>();
		for(Student stu:stuList) {
			ComboxInfo info = new ComboxInfo();
			info.setId(stu.getId());
			info.setText(stu.getUser().getName());
			
			list.add(info);
		}
		return list;
	}

	@Override
	public EasyUIDatagrid findScore(int page,int rows,int uid) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		
		//查询全部
		List<Score> list=scoreMapper.selScore(uid);
		System.out.println(list.toString());
		
		//分页信息
		PageInfo<Score> pageInfo = new PageInfo<>(list);
		//将分页信息放到EasyUIDataGrid中
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
	}

	@Override
	public ResultInfo addScore(Score score) {
		ResultInfo info = new ResultInfo();
		//判断表中是否已经存在
		Score scoreOne=scoreMapper.selScoreByCourseIdAndStudentId(score.getCourseId(), score.getStudentId());
		if(scoreOne!=null) {//已存在
			info.setFlag(false);
			info.setErrorMsg("该学生的该门课程成绩有存在，如有需求，修改即可！");
			return info;
		}else {
			int index = scoreMapper.insScore(score);
			if(index>0) {//添加成功
				info.setFlag(true);
				info.setData("成绩添加成功！");
				return info;
			}
			info.setFlag(false);
			info.setErrorMsg("成绩添加失败！请联系维护人员！");
			return info;
		}
	}

	@Override
	public ResultInfo editScore(double score,String reamrk, int id) {
		
		ResultInfo info = new ResultInfo();
		
		int index=scoreMapper.updScore(score,reamrk, id);
		if(index>0) {//修改成功
			info.setFlag(true);
			info.setData("修改成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("修改失败，请联系维护人员！");
		
		return info;
	}

	@Override
	public ResultInfo delScore(int[] ids) {
		
		ResultInfo info = new ResultInfo();
		
		int index=scoreMapper.delScore(ids);
		if(index>0) {
			info.setFlag(true);
			info.setData("删除成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("删除失败，请联系维护人员！");
		return info;
	}

}
