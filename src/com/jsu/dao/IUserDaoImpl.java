package com.jsu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.Idao.IUserDao;
import com.jsu.po.Image;
import com.jsu.po.MyMark;
import com.jsu.po.UserBean;

public class IUserDaoImpl implements IUserDao {
	
	private HibernateTemplate hibernateTemplate;  
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {  
		this.sessionFactory = sessionFactory;
      //  this.hibernateTemplate = new HibernateTemplate(sessionFactory);  
    }  
	
	public HibernateTemplate getHibernateTemplate(){
		
		if( hibernateTemplate==null)
			
			hibernateTemplate = new HibernateTemplate(sessionFactory);
	
		return hibernateTemplate;
	}
	
	@Override
	public void saveUser(UserBean user) throws SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().saveOrUpdate(user);
		
	}

	@Override
	public void delUser(UserBean user) throws SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().delete(user);
		
	}

	@Override
	public void editUsre(UserBean user) throws SQLException {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().update(user);  
		
	}

	@Override
	public List getUserByname(String userphone ,String password) throws SQLException {
		// TODO Auto-generated method stub
		
		List list = getHibernateTemplate().find("from UserBean where userphone = '" + userphone +"' and password = '"+password+"'");
		
		return list;
	}

	@Override
	public List getUser(String userphone) throws SQLException {
		// TODO Auto-generated method stub
		List user  = getHibernateTemplate().find("from UserBean where userphone = '" + userphone +"'");
		return user;
	}

	@Override
	public void addPosition(MyMark mark) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(mark);
	}

	@Override
	public List getPosition(String user_phone) throws SQLException {
		// TODO Auto-generated method stub
		List user  = getHibernateTemplate().find("from MyMark  where user_phone != "+user_phone);
		return user;
	}

	@Override
	public List FindPosition(double latitude, double longitude , double distance) throws SQLException {
		// TODO Auto-generated method stub
		
		double r = 6371;//����뾶ǧ��  
	    double dis = distance;//0.5ǧ�׾���  
	    double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));  
	    dlng = dlng*180/Math.PI;//�Ƕ�תΪ����  
	    double dlat = dis/r;  
	    dlat = dlat*180/Math.PI;          
	    double minlat =latitude-dlat;  
	    double maxlat = latitude+dlat;  
	    double minlng = longitude -dlng;  
	    double maxlng = longitude + dlng;  
	      
	 //   String hql = "from MyMark where longitude >=? and longitude =<? and latitude>=? and latitude=<? ";  
	    
	    String hql = "from MyMark where longitude >= ? and longitude <= ? and latitude >= ? and latitude <= ?";
	    Object[] values = {minlng,maxlng,minlat,maxlat};  
	      
	    List list = getHibernateTemplate().find(hql, values);  
	    
	    return list;  
	}

	@Override
	public List QueryUser(String pattern) throws SQLException {
		// TODO Auto-generated method stub
		
		List user  = getHibernateTemplate().find("from UserBean where userphone like '%"+ pattern +"%' or username  like '%"+ pattern +"%' " );
		
		return user;
	}
	@Override
	public void SaveImage(Image image) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(image);
		
	}

	@Override
	public List QueryImage(String image_id) throws SQLException {
		// TODO Auto-generated method stub
		
		List user  = getHibernateTemplate().find("from Image where image_id ="+image_id );
		
		return user;
	}

}
