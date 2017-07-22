package com.jsu.Idao;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Friends;
import com.jsu.po.UserBean;

public interface IFriendDao {
	
	public List getFriendGroup(String bwllow_uid) throws SQLException;  
	
	public List getFriends(String group_id) throws SQLException;
	public Boolean addFriends(Friends friend) throws SQLException;
}
