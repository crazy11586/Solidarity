package com.jsu.service;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Address;
import com.jsu.po.Order;
import com.jsu.po.UserBean;
import com.jsu.po.UserCondition;

public interface IOrderService {
	public void addOrder(Order order) throws Exception;
	public List QueryAllOrder(String user_phone) throws Exception;
}
