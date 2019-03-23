package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.MainDrugAdmin;

public class MainAdminTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;

	@Test
	public void customtest() {
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		// *********************************************************
		MainDrugAdmin mdAdmin = new MainDrugAdmin(2, "李泽宇", "admin", "小学生");
		session.save(mdAdmin);
		// *************************************************************
		tx.commit();
		session.close();
		sf.close();
	}
}