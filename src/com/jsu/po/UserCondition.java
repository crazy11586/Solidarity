package com.jsu.po;

public class UserCondition {
	private int condition_id;
	private String user_total_nub;
	private String user_total_time;
	private Double user_score;
	private String user_total_dist;
	private String user_phone;
	private int user_state;
	
	public int getUser_state() {
		return user_state;
	}
	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	public int getCondition_id() {
		return condition_id;
	}
	public void setCondition_id(int condition_id) {
		this.condition_id = condition_id;
	}
	public String getUser_total_nub() {
		return user_total_nub;
	}
	public void setUser_total_nub(String user_total_nub) {
		this.user_total_nub = user_total_nub;
	}
	public String getUser_total_time() {
		return user_total_time;
	}
	public void setUser_total_time(String user_total_time) {
		this.user_total_time = user_total_time;
	}
	
	public Double getUser_score() {
		return user_score;
	}
	public void setUser_score(Double user_score) {
		this.user_score = user_score;
	}
	public String getUser_total_dist() {
		return user_total_dist;
	}
	public void setUser_total_dist(String user_total_dist) {
		this.user_total_dist = user_total_dist;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	
}
