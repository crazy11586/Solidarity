package com.jsu.Iservice;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.dao.IFriendDaoImpl;
import com.jsu.dao.IUserDaoImpl;
import com.jsu.po.Friends;
import com.jsu.po.UserBean;
import com.jsu.service.IFriendService;
import com.jsu.service.IUserService;

public class FriendService implements IFriendService{
	
	
	private IFriendDaoImpl user_imple;
	
	public void setIFriendDaoImpl(IFriendDaoImpl iUserDaoImpl) {
		this.user_imple = iUserDaoImpl;
	}

	@Override
	public List getFriendGroup(String bwllow_uid) throws SQLException {
		// TODO Auto-generated method stub
		
		return user_imple.getFriendGroup(bwllow_uid);
		
	}

	@Override
	public List getFriends(String group_id) throws SQLException {
		// TODO Auto-generated method stub
		
		return user_imple.getFriends(group_id);
		
	}

	@Override
	public Boolean addFriends(Friends friend) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.addFriends(friend);
	}
	
	

}
