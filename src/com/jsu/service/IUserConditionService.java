package com.jsu.service;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.UserBean;
import com.jsu.po.UserCondition;

public interface IUserConditionService {
	public List<UserCondition> findAllPrepareUser()throws SQLException;
}
