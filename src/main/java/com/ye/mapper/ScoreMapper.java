package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ye.pojo.Course;
import com.ye.pojo.Score;
import com.ye.pojo.Student;
import com.ye.pojo.User;

public interface ScoreMapper {
	
	
	//课程名称下拉框数据
	@Select("select id,name from course where id in(select courseId from course_teacher where teacherId in(select id from teacher where uid=#{0}))")
	List<Course> selCourseIdAndName(int uid);
	//学生名称下拉框数据
	List<Student> selStuIdAndName(int uid);
	//根据课程ID和学生ID查询成绩信息
	@Select("select * from score where courseId=#{arg0} and studentId=#{arg1}")
	Score selScoreByCourseIdAndStudentId(int courseId,int studentId);
	//添加新的学生成绩
	@Insert("insert into score values(default,#{courseId},#{studentId},#{score},#{remark})")
	int insScore(Score score);
	
	//查询学生成绩
	List<Score> selScore(int uid);
	@Select("select name from user where id in(select uid from student where id=#{0})")
	List<User> selStuName(int studentId);
	@Select("select name from course where id=#{0}")
	List<Course> selCourseName(int id);
	
	
	//修改学生成绩
	@Update("update score set score=#{arg0},remark=#{arg1} where id=#{arg2}")
	int updScore(double score,String remark,int id);
	
	//删除成绩信息
	int delScore(int[] ids);
}
