package com.ye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ye.pojo.Student;
import com.ye.pojo.User;

public interface StudentManageMapper {
	@Select("select * from user where rid=1 limit #{arg0},#{arg1}")
	public List<User> selStudent(int pageStart,int pageSize);
	
	@Select("select count(*) from user where rid=#{0}")
	public int selCount(int rid);
	
	/*插入学生用户以及学生详细信息*/
	@Insert("insert into user values(default,#{account},#{password},#{name},#{sex},#{phone},#{email},#{regTime},#{regCode},#{rid})")
	public int insStudent(User user);
	@Insert("insert into student_detail values(default,#{birth},#{nation},#{politicsStatus},#{dept},#{major},#{address},#{identity},#{headPhoto},#{uid})")
	public int insStudentDetail(Student stu);
	
	@Select("select id from user where regCode=#{0}")
	public int selByRegCode(String regCode);
	
	//根据用户ID删除用户
	public int delStudent(List<Integer> ids);
	
	
	public User selById(int id);
	
	/*根据用户ID修改用户信息*/
	@Update("update user set account=#{account},name=#{name},sex=#{sex},phone=#{phone},email=#{email} where id=#{id}")
	public int updStudent(User user);
	@Update("update student_detail set birth=#{birth},nation=#{nation},politicsStatus=#{politicsStatus},dept=#{dept},major=#{major},address=#{address},identity=#{identity} where uid=#{uid}")
	public int updStudentDetail(Student stu);
}
