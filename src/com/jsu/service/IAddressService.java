package com.jsu.service;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Address;
import com.jsu.po.UserBean;
import com.jsu.po.UserCondition;

public interface IAddressService {
	public void addAddress(Address address) throws Exception;
	public List QueryAllAdress(String user_phone) throws Exception;
}
