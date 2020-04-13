package com.ye.service;

import java.util.List;

import com.ye.dto.ComboxInfo;
import com.ye.pojo.EasyUIDatagrid;
import com.ye.pojo.ResultInfo;
import com.ye.pojo.Score;

public interface ScoreService {
	/**
	 * 在下拉框中显示的课程数据
	 * @param uid
	 * @return
	 */
	public List<ComboxInfo> findCourseName(int uid);
	
	/**
	 * 在下拉框显示学生数据
	 * @param uid
	 * @return
	 */
	public List<ComboxInfo> findStuName(int uid);
	
	/**
	 * 显示该老师所带课程的学生的成绩
	 * @param uid
	 * @return
	 */
	public EasyUIDatagrid findScore(int page,int rows,int uid);
	
	/**
	 * 添加学生成绩
	 * @param score
	 * @return
	 */
	public ResultInfo addScore(Score score);
	
	/**
	 * 修改学生成绩
	 * @param score
	 * @param id
	 * @return
	 */
	public ResultInfo editScore(double score,String remark,int id);
	
	/**
	 * 删除学生成绩
	 * @param ids
	 * @return
	 */
	public ResultInfo delScore(int[] ids);
}
