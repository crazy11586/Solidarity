package com.jsu.Iservice;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.dao.IUserDaoImpl;
import com.jsu.po.Image;
import com.jsu.po.MyMark;
import com.jsu.po.UserBean;
import com.jsu.service.IUserService;

public class UserService implements IUserService{
	
	private IUserDaoImpl user_imple;
	
	
	public void setIUserDaoImpl(IUserDaoImpl iUserDaoImpl) {
		this.user_imple = iUserDaoImpl;
	}
	
	@Override
	public void saveUser(UserBean user) throws SQLException {
		
		user_imple.saveUser(user);

	}
	
	@Override
	public void delUser(UserBean user) throws SQLException {
		
		user_imple.delUser(user);

	}
	
	@Override
	public void editUsre(UserBean user) throws SQLException {
		
		user_imple.editUsre(user);
		
	}

	@Override
	public List getUserByname(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.getUserByname(username,password);
	}

	@Override
	public List getUser(String userphone) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.getUser(userphone);
	}
	

	@Override
	public void addPosition(MyMark mark) throws SQLException {
		// TODO Auto-generated method stub
		user_imple.addPosition(mark);
	}

	@Override
	public List getPosition(String user_phone) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.getPosition(user_phone);
	}

	@Override
	public List FindPosition(double latitude, double longitude,double distance) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.FindPosition(latitude, longitude ,distance);
	}

	@Override
	public List QueryUser(String pattern) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.QueryUser(pattern);
	}
	
	@Override
	public void SaveImage(Image image) throws SQLException {
		// TODO Auto-generated method stub
		user_imple.SaveImage(image);
	}

	@Override
	public List QueryImage(String image_id) throws SQLException {
		// TODO Auto-generated method stub
		return user_imple.QueryImage(image_id);
	}

}
