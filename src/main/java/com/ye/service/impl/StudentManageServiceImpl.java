package com.ye.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ye.mapper.StudentManageMapper;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Student;
import com.ye.pojo.User;
import com.ye.service.StudentManageService;
import com.ye.utils.UUIDUtil;

@Service
public class StudentManageServiceImpl implements StudentManageService{
	@Resource
	private StudentManageMapper studentManageMapper;
	
	/*分页查询学生用户信息*/
	@Override
	public EasyUIDatagrid findStudent(int rows, int page) {
		int pageStart=rows*(page-1);
		List<User> list=studentManageMapper.selStudent(pageStart,rows);
		
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(list);
		datagrid.setTotal(studentManageMapper.selCount(1));
		return datagrid;
	}
	
	/*添加学生用户*/
	@Override
	public ResultInfo addStudentUser(Student stu) {
		
		//封装User对象数据
		User user = new User();
		user.setAccount(stu.getUser().getAccount());
		user.setPassword("111111");
		user.setName(stu.getUser().getName());
		user.setSex(stu.getUser().getSex());
		user.setPhone(stu.getUser().getPhone());
		user.setEmail(stu.getUser().getEmail());
		user.setRegTime(new Date());
		user.setRegCode(UUIDUtil.getUuid());
		user.setRid(1);
		
		/*student.getUser().setPassword("111111");
		student.getUser().setRegTime(formatter.format(new Date()));
		//设置注册码
		student.getUser().setRegCode(UUIDUtil.getUuid());
		student.getUser().setRid(1);*/
		
		int index=studentManageMapper.insStudent(user);
		if(index>0) {
			/*//格式化生日
			String[] births=stu.getBirth().split("/");
			StringBuffer sb = new StringBuffer();
			sb.append(births[2]+"-");
			sb.append(births[1]+"-");
			sb.append(births[0]);
			String birth=sb.toString();
			
			//格式化后进行赋值
			stu.setBirth(birth);*/
			
			//通过注册码查询user的id属性
			stu.setUid(studentManageMapper.selByRegCode(user.getRegCode()));
			
			index += studentManageMapper.insStudentDetail(stu);
		}
		ResultInfo info = new ResultInfo();
		if(index==2) {//成功时
			info.setFlag(true);
			info.setData("添加学生用户成功！");
			return info;
		}
		//失败时
		info.setFlag(false);
		info.setErrorMsg("添加学生用户失败，请联系维护人员！");
		return info;
	}

	@Override
	public ResultInfo delStudentUser(int[] idsStr) {
		//将int数组转换成list集合
		List<Integer> ids = Arrays.stream( idsStr ).boxed().collect(Collectors.toList());
		
	    int index=0;
		index=studentManageMapper.delStudent(ids);
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
	
	/*回显数据，将数据展示到页面中*/
	@Override
	public User findStudentUser(int id) {
		
		return studentManageMapper.selById(id);
	}

	@Override
	public ResultInfo editStudentUser(Student stu) {
		//封装User数据对象
		User user = new User();
		user.setId(stu.getUid());
		user.setAccount(stu.getUser().getAccount());
		user.setName(stu.getUser().getName());
		user.setSex(stu.getUser().getSex());
		user.setPhone(stu.getUser().getPhone());
		user.setEmail(stu.getUser().getEmail());
		
		int index=studentManageMapper.updStudent(user);
		index+=studentManageMapper.updStudentDetail(stu);
		
		ResultInfo info = new ResultInfo();
		if(index==2) {
			//修改成功
			info.setFlag(true);
			info.setData("修改学生信息成功！");
			return info;
		}
		info.setFlag(false);
		info.setErrorMsg("修改学生信息失败！请联系维护人员！");
		return info;
	}
}
