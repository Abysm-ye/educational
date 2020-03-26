package com.ye.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIDatagrid implements Serializable{
	//当前页面数据
	private List<?> rows;
	//数据总数
	private int total;
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
