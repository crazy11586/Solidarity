package com.jsu.po;

public class Address {
	private String user_name;
	private String user_phone;
	private String phone;
	private String user_address;
	private String _uid;
	
	
	public Address() {
		super();
	}


	public Address(String user_name, String user_phone, String phone, String user_address , String _uid) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.phone = phone;
		this.user_address = user_address;
		this._uid = _uid;
	}
	
	
	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
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

	
}
