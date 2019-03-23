package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.DrugClassMotify;

public class DrugClassTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;
	@Test
	public void drugClassTest() {
		Configuration configuration= new Configuration().configure();
		sf = configuration.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		DrugClassMotify da = new DrugClassMotify(1, "中成药", "耳鼻喉科用药", "鼻病");
		DrugClassMotify db = new DrugClassMotify(1, "中成药", "耳鼻喉科用药", "咽喉病");
		DrugClassMotify dc = new DrugClassMotify(1, "中成药", "骨伤科用药", "");
		DrugClassMotify dd = new DrugClassMotify(1, "民族药", "", "");
		session.save(da);
		session.save(db);
		session.save(dc);
		session.save(dd);
		tx.commit();
		session.close();
		
		
	}

}
