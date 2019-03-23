package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.entity.DrugStoreInfo;
import com.util.HibernateUtil;

public class DrugStoreInfoTest {
	@Test
	public void haveatry() {
	DrugStoreInfo drugStoreInfo= new DrugStoreInfo("北京市昌平区回龙观北农路2号");
	Session session = HibernateUtil.openSession();
	Transaction tx = session.beginTransaction();
	session.save(drugStoreInfo);
	tx.commit();
	session.close();
	}
}
