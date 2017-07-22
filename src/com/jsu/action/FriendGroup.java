package com.jsu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsu.Iservice.FriendService;
import com.jsu.Iservice.UserService;
import com.jsu.po.Friends;
import com.jsu.po.Group;
import com.jsu.po.Group2;
import com.jsu.po.UserBean;
import com.opensymphony.xwork2.ActionSupport;

public class FriendGroup extends ActionSupport{
	
	private List list;
	private List list2;
	private String action;
	private String group_name;
	private String user_id;

	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String Test(){
		
		if("getgroup".equals(action)){
				getgroup();
		}else if("getallgroup".equals(action)){
				getallgroup();
		}

			return SUCCESS;
	}
	
	public void getgroup(){
		FriendService service =(FriendService)ApplicationContextHelper.getBean("friendService");
		try {
			list2 = service.getFriendGroup(user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getallgroup(){
			
		try {
			
			FriendService service =(FriendService)ApplicationContextHelper.getBean("friendService");
			list = service.getFriendGroup(user_id);
			list2 = new ArrayList<>();
			List allUser ;
			List temp ;
			
			System.out.println(list.size());
			for(int i = 0 ; i < list.size() ; i ++){
				allUser = new ArrayList<UserBean>();
				Group group = (Group) list.get(i);
				temp = service.getFriends(group.getGroup_id());
				for (int j = 0 ; j < temp.size() ; j ++ ){
					
					Friends userbean = (Friends) temp.get(j);
					UserService service2 =(UserService)ApplicationContextHelper.getBean("userService");
					userbean.get_fname();
					String str = userbean.get_fid();
					
					List userbean2 = (List) service2.getUser(str);
					
					allUser.add((UserBean)userbean2.get(0));
					
				}
				
				Group2 group_2 = new Group2();
				group_2.setBeans(allUser);
				group_2.setGroup_id(group.getGroup_id());
				group_2.setBellow_uid(group.getBellow_uid());
				group_2.setGroup_name(group.getGroup_name());
				
				list2.add(group_2);
				
				
			}
			//System.out.println(list2.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
