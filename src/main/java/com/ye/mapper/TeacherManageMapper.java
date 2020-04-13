package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ye.pojo.Teacher;
import com.ye.pojo.User;

public interface TeacherManageMapper {
	
	/*根据工号查询教师信息*/
	@Select("select * from user where account=#{0}")
	public User selUserByAccount(String account);
	/*插入教师用户信息*/
	@Insert("insert into user values(default,#{account},#{password},#{name},#{sex},#{phone},#{email},#{regTime},#{regCode},#{rid})")
	public int insTeaUser(User user);
	@Insert("insert into teacher values(default,#{birth},#{nation},#{politicsStatus},#{title},#{address},#{identity},#{headPhoto},#{uid})")
	public int insTeacher(Teacher tea);
	@Select("select id from user where regCode=#{0}")
	public int selByRegCode(String regCode);
	
	/*分页查询教师用户信息*/
	@Select("select * from user where rid=#{0}")
	public List<User> selAllTeaUser(int rid);
	
	/*删除教师用户*/
	public int delTeaUser(int[] ids);
	
	/*回显数据，方便修改数据*/
	public User selTeaUserById(int id);
	
	/*根据用户ID修改用户信息*/
	@Update("update user set account=#{account},name=#{name},sex=#{sex},phone=#{phone},email=#{email} where id=#{id}")
	public int updTeaUser(User user);
	@Update("update teacher set birth=#{birth},nation=#{nation},politicsStatus=#{politicsStatus},title=#{title},address=#{address},identity=#{identity} where uid=#{uid}")
	public int updTeacher(Teacher tea);
}
