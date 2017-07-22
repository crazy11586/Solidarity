package com.jsu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.Idao.IFriendDao;
import com.jsu.Idao.IUserDao;
import com.jsu.po.Friends;
import com.jsu.po.UserBean;

public class IFriendDaoImpl implements IFriendDao {
	
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
	public List getFriendGroup(String bwllow_uid) throws SQLException {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().find("from Group where bellow_uid = '" + bwllow_uid +"'");
		return list;
	}

	@Override
	public List getFriends(String group_id) throws SQLException {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().find("from Friends where group_id = '" + group_id +"'");
		return list;
	}

	@Override
	public Boolean addFriends(Friends friend)  {
		// TODO Auto-generated method stub
		
		
		try{
			
			getHibernateTemplate().saveOrUpdate(friend);
			
		}catch(Exception e){
			
			return false;
			
		}
		
		return true;
	}

}
