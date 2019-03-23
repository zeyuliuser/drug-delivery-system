package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.entity.Custom;

public class CustomCheckTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;
	private String st = "";
	Custom c;

	@Test
	public void customtest() {
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		// ***********************************************
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Custom.class);
		criteria.add(Restrictions.eq("username", st));
		List results = criteria.list();
		System.out.println(results);

		// ***********************************************
		tx.commit();
		session.close();
		sf.close();
	}

}
