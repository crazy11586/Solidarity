package com.jsu.action;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsu.Iservice.UserService;
import com.jsu.po.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String action;
	private String username;
	private String password;
	private List list;
	private String userimg;
	private String userphone;
	private String token;
	
	public String getAction() {
		return action;
	}

	public String getToken() {
		return token;
	}




	public void setToken(String token) {
		this.token = token;
	}


	public void setAction(String action) {
		this.action = action;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getUserimg() {
		return userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public LoginAction(){
		
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "error";
	}
	
	public String Test(){
		
		if("login".equals(action)){
			login();
		}else if("regist".equals(action)){
			regist();
		}
		return SUCCESS;
		
	}
	
	public void login(){	
		if (userphone == null || userphone.length() == 0) {
			//	super.addActionError("");
			return ;
		}
		
		if (password == null || password.length() == 0) {
			//	super.addActionError("瀵嗙爜涓嶈兘涓虹┖");
			return ;
		}
		
		try {
			UserService service =(UserService)ApplicationContextHelper.getBean("userService");
			list = service.getUserByname(userphone,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void regist(){
		if (username == null || username.length() == 0) {
			//	super.addActionError("");
			return ;
		}
		
		if (password == null || password.length() == 0) {
			//	super.addActionError("瀵嗙爜涓嶈兘涓虹┖");
			return ;
		}
		UserBean user = new UserBean();
		
		user.setPassword(password);
		user.setUserimg(userimg);
		user.setUsername(username);
		user.setUserphone(userphone);
		user.setToken(token);
		
		try {
			UserService service =(UserService)ApplicationContextHelper.getBean("userService");
			service.saveUser(user);
			list = service.getUserByname(userphone,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
