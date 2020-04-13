package com.ye.pojo;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
	private int id;
	private String name;
	private String type;
	private double credit;
	private String checkType;
	private String time;
	private String timeweek;
	private String site;
	
	/*关联属性*/
	private int tid;
	private List<User> users;
	private List<Score> scores;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTimeweek() {
		return timeweek;
	}
	public void setTimeweek(String timeweek) {
		this.timeweek = timeweek;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
}
