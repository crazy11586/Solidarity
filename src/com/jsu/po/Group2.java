package com.jsu.po;

import java.util.List;

public class Group2 {
	
	private String Group_id;
	private String group_name;
	private String bellow_uid;
	
	private List<UserBean> beans;
	
	
	
	public List<UserBean> getBeans() {
		return beans;
	}
	public void setBeans(List<UserBean> beans) {
		this.beans = beans;
	}
	public String getGroup_id() {
		return Group_id;
	}
	public void setGroup_id(String group_id) {
		Group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getBellow_uid() {
		return bellow_uid;
	}
	public void setBellow_uid(String bellow_uid) {
		this.bellow_uid = bellow_uid;
	}
	
	
}
