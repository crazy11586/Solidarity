package com.jsu.Iservice;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.dao.IUserDaoImpl;
import com.jsu.dao.UserConditionDao;
import com.jsu.po.UserBean;
import com.jsu.po.UserCondition;
import com.jsu.service.IUserConditionService;
import com.jsu.service.IUserService;

public class UserConditionService implements IUserConditionService{
	
	private UserConditionDao userConditionDao;
	
	public void setUserConditionDao(UserConditionDao userConditionDao) {
		this.userConditionDao = userConditionDao;
	}
	
	public List<UserCondition> findAllPrepareUser() throws SQLException {
		List<UserCondition> list = userConditionDao.findAllPrepareUser();
		return list;
	}
}
