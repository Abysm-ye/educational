package com.ye.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ye.pojo.Course;
import com.ye.pojo.Score;
import com.ye.pojo.User;

public interface StudentMapper {
	
	public User selStuInfoById(int id);
	
	/*查询学生课表*/
	public List<Course> selStuCourse(int uid);
	/*查询授课老师的姓名*/
	@Select("select name from user where id in(select uid from teacher where id in(select teacherId from course_teacher where courseId=#{0}))")
	public List<User> selTeaName(int courseId);
	
	/*查询学生选修课程列表*/
	public List<Course> selElective();
	
	/*查询课程根据课程ID和用户ID*/
	@Select("select * from course_student where courseId=#{arg0} and studentId in(select id from student where uid=#{arg1})")
	public Object selCourseById(int courseId,int uid);
	@Insert("insert into course_student values(default,#{arg0},(select id from student where uid=#{arg1}))")
	public int insElective(int courseId,int uid);
	
	
	/*学生成绩*/
	public List<Score> selScore(int uid);
	/*根据课程ID查询成绩*/
	@Select("select name from course where id=#{0}")
	public List<Course> selCourseByCourseId(int courseId);
	
}
