package com.jsu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jsu.Idao.IUserConditionDao;
import com.jsu.Idao.IUserDao;
import com.jsu.po.UserCondition;

public class UserConditionDao implements IUserConditionDao {
	
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
	public List<UserCondition> findAllPrepareUser() throws SQLException {
		String hql = "from UserCondition order by user_score desc";
		return this.getHibernateTemplate().getSessionFactory().
				openSession().createQuery(hql).setFirstResult(0).setMaxResults(10).list();
	}
}
