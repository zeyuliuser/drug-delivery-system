package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.LogisticAdmin;



public class LogisticAdminTest {
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
		LogisticAdmin c=new LogisticAdmin(1, 1, "admin", "admin", "北农酒店", "张无忌", "man", "13546987897");
		session.save(c);
		//*************************************************************
		tx.commit();
		session.close();
		sf.close();
	}
}
