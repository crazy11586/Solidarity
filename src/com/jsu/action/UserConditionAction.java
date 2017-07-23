package com.jsu.action;

import java.sql.SQLException;
import java.util.List;

import com.jsu.Iservice.UserConditionService;
import com.opensymphony.xwork2.ActionSupport;

public class UserConditionAction extends ActionSupport{
	
	private List list;
	private UserConditionService userConditionService;
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

    public String Query() throws SQLException{  
    	userConditionService =  (UserConditionService) ApplicationContextHelper.getBean("userConditionService");
    	list = userConditionService.findAllPrepareUser();
        return SUCCESS;  
    }  
}
