package com.jsu.Idao;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Address;
import com.jsu.po.Friends;
import com.jsu.po.Order;
import com.jsu.po.UserBean;

public interface IOrderDao {
	void addOrder(Order order) throws Exception;
	List QueryAllOrder(String user_phone) throws Exception;
}
