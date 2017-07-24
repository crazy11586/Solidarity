package com.jsu.action;

import java.util.List;
import java.util.UUID;

import com.jsu.Iservice.OrderService;
import com.jsu.po.Address;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private String user_phone;
	
	private List list;
	
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}



	OrderService orderService;
	public String Add(){

		if(orderService == null){

			orderService = (OrderService) ApplicationContextHelper.getBean("orderService");
		}
		
		return SUCCESS;
	}

	public String Query(){
		
		if(orderService == null){

			orderService = (OrderService) ApplicationContextHelper.getBean("orderService");
		}
		
		try {
			list = orderService.QueryAllOrder(user_phone);
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
