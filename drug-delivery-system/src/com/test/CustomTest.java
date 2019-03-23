package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.Custom;

public class CustomTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;

	@Test
	public void customtest() {
		Configuration conf=new Configuration().configure();
		sf=conf.buildSessionFactory();
		session=sf.openSession();
		tx=session.beginTransaction();
		//*********************************************************
		Custom c=new Custom(0, "mrban","路小班", "admin", "man", "18811361877");
		session.save(c);
		//*************************************************************
		tx.commit();
		session.close();
		sf.close();
	}

}
