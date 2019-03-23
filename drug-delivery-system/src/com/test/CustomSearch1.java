package com.test;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.entity.Custom;
import com.util.HibernateUtil;


public class CustomSearch1 {
	String name = "li";
    @Test
	public void cutomsearch() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		//******************************************************************
		Query q = session.createQuery("from Custom c where c.username=?");
		q.setParameter(0, name);
		List<Custom> list =q.list();
		//System.out.println(list.get(0).getPassword().toString());
		//******************************************************************
		tx.commit();
		session.close();
		System.out.println(list.toString());
		if (list.get(0).getPassword()!= null) {
			System.out.println(1);
			
		}else {
			System.out.println(0);
		}
	}

}
