package com.jsu.action;

import java.util.List;
import java.util.UUID;

import com.jsu.Iservice.AddressService;
import com.jsu.po.Address;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	private String user_name;
	private String user_phone;
	private String phone;
	private String user_address;
	private String _uid;
	
	private List list;
	
	
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String get_uid() {
		return _uid;
	}
	public void set_uid(String _uid) {
		this._uid = _uid;
	}
	
	AddressService addressService;
	public String Add(){

		if(addressService == null){

			addressService = (AddressService) ApplicationContextHelper.getBean("addressService");
			
		}
		if(_uid == null){
			_uid = UUID.randomUUID().toString().replace("-", ""); 
		}
			
		try {
				
				addressService.addAddress(new Address(user_name,user_phone,phone,user_address,_uid));
				
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String Query(){
		
		if(addressService == null){

			addressService = (AddressService) ApplicationContextHelper.getBean("addressService");
			
		}
		
		try {
			list = addressService.QueryAllAdress(user_phone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	
}
