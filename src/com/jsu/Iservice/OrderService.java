package com.jsu.Iservice;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.dao.IAddressDaoImpl;
import com.jsu.dao.IFriendDaoImpl;
import com.jsu.dao.IOrderDaoImpl;
import com.jsu.dao.IUserDaoImpl;
import com.jsu.po.Address;
import com.jsu.po.Friends;
import com.jsu.po.Order;
import com.jsu.po.UserBean;
import com.jsu.service.IAddressService;
import com.jsu.service.IFriendService;
import com.jsu.service.IOrderService;
import com.jsu.service.IUserService;

public class OrderService implements IOrderService{
	
	
	private IOrderDaoImpl order_imple;
	
	public void setIOrderDaoImpl(IOrderDaoImpl iOrderDaoImpl) {
		this.order_imple = iOrderDaoImpl;
	}
	
	@Override
	public void addOrder(Order order) throws Exception {
		 order_imple.addOrder(order);
	}

	@Override
	public List QueryAllOrder(String user_phone) throws Exception {
		return order_imple.QueryAllOrder(user_phone);
	}

}
