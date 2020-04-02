package com.ye.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ye.mapper.TeacherManageMapper;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Teacher;
import com.ye.pojo.User;
import com.ye.service.TeacherManageService;
import com.ye.utils.UUIDUtil;

@Service
public class TeacherManageServiceImpl implements TeacherManageService{
	
	@Resource
	private TeacherManageMapper teacherManageMapper;
	
	@Override
	public ResultInfo addTeaUser(User user) {
		//封装user数据对象
		user.setPassword("111111");
		user.setRegTime(new Date());
		user.setRegCode(UUIDUtil.getUuid());
		user.setRid(2);
		//封装teacher对象数据
		Teacher tea=new Teacher();
		tea.setBirth(user.getTeacher().getBirth());
		tea.setNation(user.getTeacher().getNation());
		tea.setPoliticsStatus(user.getTeacher().getPoliticsStatus());
		tea.setTitle(user.getTeacher().getTitle());
		tea.setAddress(user.getTeacher().getAddress());
		tea.setIdentity(user.getTeacher().getIdentity());
		tea.setHeadPhoto(user.getTeacher().getHeadPhoto());
		
		int index=teacherManageMapper.insTeaUser(user);
		if(index>0) {
			tea.setUid(teacherManageMapper.selByRegCode(user.getRegCode()));
			
			index+=teacherManageMapper.insTeacher(tea);
		}
		//封装响应数据
		ResultInfo info = new ResultInfo();
		if(index==2) {
			info.setFlag(true);
			info.setData("添加教师用户成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("添加教师用户失败，请联系维护人员！");
		return info;
	}

	@Override
	public EasyUIDatagrid findByPage(int page,int rows) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		//查询全部
		List<User> list=teacherManageMapper.selAllTeaUser(2);
		//分页信息
		PageInfo<User> pageInfo = new PageInfo<>(list);
		//将分页信息放到EasyUIDataGrid中
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(pageInfo.getList());
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
		
	}

	@Override
	public ResultInfo delTeaUser(int[] ids) {
		int index=teacherManageMapper.delTeaUser(ids);
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
	public User echoData(int id) {
		return teacherManageMapper.selTeaUserById(id);
	}

	@Override
	public ResultInfo editTeaUser(User user) {
		/*封装teacher对象数据*/
		Teacher tea = new Teacher();
		tea.setBirth(user.getTeacher().getBirth());
		tea.setNation(user.getTeacher().getNation());
		tea.setPoliticsStatus(user.getTeacher().getPoliticsStatus());
		tea.setTitle(user.getTeacher().getTitle());
		tea.setAddress(user.getTeacher().getAddress());
		tea.setIdentity(user.getTeacher().getIdentity());
		
		int index = teacherManageMapper.updTeaUser(user);
		if(index>0) {
			tea.setUid(user.getId());
			index += teacherManageMapper.updTeacher(tea);
		}
		
		ResultInfo info = new ResultInfo();
		if(index==2) {
			info.setFlag(true);
			info.setData("教师信息修改成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("教师信息修改失败，请联系维护人员！");
		return info;
	}

}
