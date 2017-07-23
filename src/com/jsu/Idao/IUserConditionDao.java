package com.jsu.Idao;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.UserCondition;


public interface IUserConditionDao {  
    public List<UserCondition> findAllPrepareUser() throws SQLException;  
}  