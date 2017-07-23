package com.jsu.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationContext;

import com.jsu.Iservice.UserConditionService;
import com.opensymphony.xwork2.ActionSupport;

public class GetDataAction extends ActionSupport implements ServletResponseAware{  
    
    private List list;
    private String action;
    private ApplicationContext context;
    private UserConditionService userConditionService;

	public void setUserConditionService(UserConditionService userConditionService) {
		this.userConditionService = userConditionService;
	}
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List getList() {  
        return list;  
    }  
  
    public void setList(List list) {  
        this.list = list;  
    }        

    public String Test() throws SQLException{  
    	userConditionService.findAllPrepareUser();
        return SUCCESS;  
    }    

    public String getOrder(){
    	
    	return "success";
    }
    
	private void GetCustomer() {
		
//		CustomerService service =(CustomerService)ApplicationContextHelper.getBean("customerService");
//    	list = service.getAllCustomer();
	}	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		arg0.setHeader("Access-Control-Allow-Origin", "*");
	}
 
}
