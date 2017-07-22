package com.jsu.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsu.Iservice.FriendService;
import com.jsu.Iservice.UserService;
import com.jsu.po.Friends;
import com.opensymphony.xwork2.ActionSupport;

public class FriendAction extends ActionSupport{
		
	private String _uid;
	private String _fid;
	private String _fname;
	private String group_id;
	private List list;
	
	private String pattern;
	
	

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String get_fid() {
		return _fid;
	}

	public void set_fid(String _fid) {
		this._fid = _fid;
	}

	public String get_fname() {
		return _fname;
	}

	public void set_fname(String _fname) {
		this._fname = _fname;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}


	public String Add(){
		
		list = new ArrayList<String>();
		Friends friend = new Friends();
		friend.set_id(UUID.randomUUID().toString().replace("-", ""));
		friend.set_fname(_fname);
		friend.set_uid(_uid);
		friend.set_fid(_fid);
		friend.setGroup_id(group_id);
		
		FriendService service =(FriendService)ApplicationContextHelper.getBean("friendService");
		try {
			
			service.addFriends(friend);
			list.add("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list.add("error");
		}
		
		return SUCCESS;
			
	}
	
	public String Query() throws SQLException{
		System.out.println(FriendAction.convert(pattern));
		UserService service =(UserService)ApplicationContextHelper.getBean("userService");
		list = service.QueryUser(FriendAction.convert(pattern));
		return SUCCESS;
	}
	
	public static String convert(String str){

	       try {

	           byte[] bytes = str.getBytes("ISO-8859-1");

	           return new String(bytes,"UTF-8");

	       } catch (UnsupportedEncodingException e) {

	           e.printStackTrace();

	           return str;

	       }

	    }
	
}
