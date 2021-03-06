package com.jsu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.Idao.IAddressDao;
import com.jsu.Idao.IUserDao;
import com.jsu.po.Address;
import com.jsu.po.MyMark;
import com.jsu.po.UserBean;

public class IAddressDaoImpl implements IAddressDao {
	
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
	public void addAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(address);
	}

	@Override
	public List QueryAllAdress(String user_phone) throws Exception {
		// TODO Auto-generated method stub
		List user  = getHibernateTemplate().find("from Address where user_phone ="+user_phone );
		
		return user;

	}

}
