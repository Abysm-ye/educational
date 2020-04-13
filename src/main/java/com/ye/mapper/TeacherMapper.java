package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ye.pojo.Course;

public interface TeacherMapper {
	
	@Select("select * from course where id in(select courseId from course_teacher where teacherId in(select id from teacher where uid=#{0}))")
	public List<Course> selTeaCourse(int uid);
}
