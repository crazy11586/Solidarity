package com.jsu.po;

import java.util.Date;

public class Order {
    
	private String image_id;
	
    private Integer order_id;
    //流水号
	private String order_no;
    //订单创建地址
    private String create_addr;
    //用户手机号
    private String user_phone;
    //送货地址
    private String order_delivery_address;
    //送货地址id
    private String order_delivery_address_uid;
    //收货地址
    private String order_shipping_address;
    //收货地址id
    private String order_shipping_address_uid;
    //购物地址
    private String order_shopping_address;
    //购物地址id
    private String order_shopping_address_uid;
    //价格
    private Double order_price;
    //价格等级
    private Integer order_price_level;
    //类型
    private Integer order_kind;
    //备注
    private String order_desc;
    //取货时间
    private Date order_picktime;
    //保险
    private Integer order_insurance;
    
	//关联的状态表
    private String user_order_statement_id;

   
	public String getImage_id() {
		return image_id;
	}

	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getCreate_addr() {
		return create_addr;
	}

	public void setCreate_addr(String create_addr) {
		this.create_addr = create_addr;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getOrder_delivery_address() {
		return order_delivery_address;
	}

	public void setOrder_delivery_address(String order_delivery_address) {
		this.order_delivery_address = order_delivery_address;
	}

	public String getOrder_delivery_address_uid() {
		return order_delivery_address_uid;
	}

	public void setOrder_delivery_address_uid(String order_delivery_address_uid) {
		this.order_delivery_address_uid = order_delivery_address_uid;
	}

	public String getOrder_shipping_address() {
		return order_shipping_address;
	}

	public void setOrder_shipping_address(String order_shipping_address) {
		this.order_shipping_address = order_shipping_address;
	}

	public String getOrder_shipping_address_uid() {
		return order_shipping_address_uid;
	}

	public void setOrder_shipping_address_uid(String order_shipping_address_uid) {
		this.order_shipping_address_uid = order_shipping_address_uid;
	}

	public String getOrder_shopping_address() {
		return order_shopping_address;
	}

	public void setOrder_shopping_address(String order_shopping_address) {
		this.order_shopping_address = order_shopping_address;
	}

	public String getOrder_shopping_address_uid() {
		return order_shopping_address_uid;
	}

	public void setOrder_shopping_address_uid(String order_shopping_address_uid) {
		this.order_shopping_address_uid = order_shopping_address_uid;
	}

	public Double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}

	public Integer getOrder_price_level() {
		return order_price_level;
	}

	public void setOrder_price_level(Integer order_price_level) {
		this.order_price_level = order_price_level;
	}

	public Integer getOrder_kind() {
		return order_kind;
	}

	public void setOrder_kind(Integer order_kind) {
		this.order_kind = order_kind;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public Date getOrder_picktime() {
		return order_picktime;
	}

	public void setOrder_picktime(Date order_picktime) {
		this.order_picktime = order_picktime;
	}

	public Integer getOrder_insurance() {
		return order_insurance;
	}

	public void setOrder_insurance(Integer order_insurance) {
		this.order_insurance = order_insurance;
	}

	public String getUser_order_statement_id() {
		return user_order_statement_id;
	}

	public void setUser_order_statement_id(String user_order_statement_id) {
		this.user_order_statement_id = user_order_statement_id;
	}
}
