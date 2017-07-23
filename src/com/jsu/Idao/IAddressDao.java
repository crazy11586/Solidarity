package com.jsu.Idao;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Address;
import com.jsu.po.Friends;
import com.jsu.po.UserBean;

public interface IAddressDao {
	
	public void addAddress(Address address) throws Exception;
	public List QueryAllAdress(String user_phone) throws Exception;
}
