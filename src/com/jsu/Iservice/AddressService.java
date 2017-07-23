package com.jsu.Iservice;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.dao.IAddressDaoImpl;
import com.jsu.dao.IFriendDaoImpl;
import com.jsu.dao.IUserDaoImpl;
import com.jsu.po.Address;
import com.jsu.po.Friends;
import com.jsu.po.UserBean;
import com.jsu.service.IAddressService;
import com.jsu.service.IFriendService;
import com.jsu.service.IUserService;

public class AddressService implements IAddressService{
	
	
	private IAddressDaoImpl user_imple;
	
	public void setIAddressDaoImpl(IAddressDaoImpl iUserDaoImpl) {
		this.user_imple = iUserDaoImpl;
	}

	@Override
	public void addAddress(Address address) throws Exception {
		user_imple.addAddress(address);
		
	}

	@Override
	public List QueryAllAdress(String user_phone) throws Exception {
		// TODO Auto-generated method stub
		return user_imple.QueryAllAdress(user_phone);
	}

	
	

}
