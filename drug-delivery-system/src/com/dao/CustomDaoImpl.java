package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.Custom;
import com.util.HibernateUtil;

@SuppressWarnings("deprecation")
public  class CustomDaoImpl implements CustomDao {

	@Override
	public void save(Custom c) {
		// TODO Auto-generated method stub
		  Session session = HibernateUtil.openSession();
		    Transaction tx = session.beginTransaction();
		    session.save(c);
		    tx.commit();
		    session.close();
    	}
	public boolean checkexist(String username) {
		Session session = HibernateUtil.openSession();
	    Transaction tx = session.beginTransaction();
        Criteria criteria=session.createCriteria(Custom.class);
        criteria.add(Restrictions.eq("username",username));
		@SuppressWarnings("rawtypes")
		List results = criteria.list();   
	    tx.commit();
	    session.close();
	    if(results.size()!= 0) {
	    	return true;
	    }else {
			return false;
		}	
	    
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Custom searchByUsername(String username) {
		    Session session = HibernateUtil.openSession();		   
		    Query q = session.createQuery("from Custom c where c.username=?");
			q.setParameter(0, username);
			List<Custom> list =q.list();					    
		    if (list.toString()!="[]") {
		    	Custom custom=session.get(Custom.class, list.get(0).getCid());
				return custom;
			}else {
				
				return null;
			}
		    
		   
	}
	@Override
	public void updateCustomById(int i, String username, String password, String cgender, String realname,
			String phone) {
		Session session = HibernateUtil.openSession();
	    Transaction tx = session.beginTransaction();
	   
	    Custom custom=session.get(Custom.class, i) ;
	    custom.setUsername(username);
	    custom.setRealname(realname);
	    custom.setphone(phone);
	    custom.setPassword(password);
	    custom.setCgender(cgender);
	    session.update(custom);
	    
	    tx.commit();
	    session.close();
		
		
	};

}
