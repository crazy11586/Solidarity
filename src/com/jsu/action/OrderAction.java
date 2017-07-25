package com.jsu.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jsu.Iservice.OrderService;
import com.jsu.po.Address;
import com.jsu.po.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private String user_phone;
	private String order_json;
	
	private List list;
	

	public String getOrder_json() {
		return order_json;
	}

	public void setOrder_json(String order_json) {
		this.order_json = order_json;
	}

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
	public String Add() throws Exception{
		HttpServletRequest request = (HttpServletRequest)  ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		if(orderService == null){

			BufferedReader br = request.getReader();

			String str, wholeStr = "";
			while((str = br.readLine()) != null){
				wholeStr += str;
			}
			System.out.println(wholeStr);

			Gson gson = new Gson();
			orderService = (OrderService) ApplicationContextHelper.getBean("orderService");
			Order order = gson.fromJson(wholeStr, Order.class);
			order.setOrder_id(10);
			try {
				
				orderService.addOrder(order);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
