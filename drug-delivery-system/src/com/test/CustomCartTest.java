package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import com.entity.CustomCart;


import com.util.HibernateUtil;

public class CustomCartTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;


	@Test
	public void customtest() {
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		// ***********************************************
		Criteria criteria = session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("did", 2));
		criteria.add(Restrictions.eqOrIsNull("cid", 2));
		List<CustomCart> list =criteria.list();
      
        	System.out.println(list.toString());

		/*CustomCart cart =new CustomCart(1, 2, 3, 6, 53.2);
		session.save(cart);*/
		// ***********************************************
		tx.commit();
		session.close();
		sf.close();
	}


}
