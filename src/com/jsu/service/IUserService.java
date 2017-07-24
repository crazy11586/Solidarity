package com.jsu.service;

import java.sql.SQLException;
import java.util.List;

import com.jsu.po.Image;
import com.jsu.po.MyMark;
import com.jsu.po.UserBean;


public interface IUserService {
	
	public void saveUser(UserBean user) throws SQLException;  
	  
    public void delUser(UserBean user) throws SQLException;  
  
    public void editUsre(UserBean user) throws SQLException;  

    public List getUser(String userphone) throws SQLException;
    
    public List getUserByname(String username , String password) throws SQLException;  
    
    public List QueryUser(String pattern) throws SQLException;
    
    public void addPosition(MyMark mark) throws SQLException;
    
    public List getPosition(String user_phone) throws SQLException;
    
    public List FindPosition(double latitude , double longitude , double distance)throws SQLException;
    
    public void SaveImage(Image image) throws SQLException;
    
    public List QueryImage(String image_id) throws SQLException;


}
