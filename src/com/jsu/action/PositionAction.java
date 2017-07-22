package com.jsu.action;

import java.sql.SQLException;
import java.util.List;

import com.jsu.Iservice.UserService;
import com.jsu.po.MyMark;
import com.opensymphony.xwork2.ActionSupport;

public class PositionAction extends ActionSupport{
	
	private String action;
	
	//add_position
	private double latitude;
	private double longitude;
	private String user_phone;
	private String user_name;
	private String address;
	private double distance;
	
	
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

	private List list;
	
	public String getAction() {
		return action;
	}

	

	public List getList() {
		return list;
	}



	public void setList(List list) {
		this.list = list;
	}



	public void setAction(String action) {
		this.action = action;
	}

	

	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String Test(){
		
		if("upload".equals(action)){
			upload();
		}else if("get".equals(action)){
			get();
		}else if("find".equals(action)){
			find();
		}
		
		return SUCCESS;
		
	}
	
	public void find(){
		try {
			UserService service =(UserService)ApplicationContextHelper.getBean("userService");
			list = service.FindPosition(latitude, longitude,distance);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void upload(){
	
		
		MyMark mymark = new MyMark();
		mymark.setLatitude(latitude);
		mymark.setLongitude(longitude);
		mymark.setUser_name(user_name);
		mymark.setUser_phone(user_phone);
		mymark.setAddress(FriendAction.convert(address));
		try {
			UserService service =(UserService)ApplicationContextHelper.getBean("userService");
			service.addPosition(mymark);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public void get(){
		
		try {
			UserService service =(UserService)ApplicationContextHelper.getBean("userService");
			list = service.getPosition(user_phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
