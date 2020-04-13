package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ye.pojo.Course;
import com.ye.pojo.User;

public interface CourseManageMapper {
	
	/*查询授课老师ID*/
	List<User> selTeaIdAndName();
	
	
	/*新增课程信息*/
	@Insert("insert into course values(default,#{name},#{type},#{credit},#{checkType},#{time},#{timeweek},#{site})")
	int insCourse(Course course);
	@Insert("insert into course_teacher values(default,(select max(id) from course),#{0})")
	int insCourserTeacher(int teacherId);
	
	
	/*查询所有课程信息*/
	@Select("select * from course")
	List<Course> selAll();
	@Select("select name from user where id in(select uid from teacher where id in(select teacherId from course_teacher where courseId=#{0}))")
	List<User> selTeaName(int courseId);
	
	/*删除课程信息*/
	public int delCourse(int[] ids);
	
	/*根据用户ID修改用户信息*/
	@Update("update course set name=#{name},type=#{type},credit=#{credit},checkType=#{checkType},time=#{time},timeweek=#{timeweek},site=#{site} where id=#{id}")
	public int updCourse(Course course);
	
	
}
