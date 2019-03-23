package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.entity.CompStock;
import com.entity.Drug;
import com.util.HibernateUtil;

public class CompStockTest {
	@Test
	public void CompStockFinish() {
		CompStock compStock = new CompStock();
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Drug.class);
		List<Drug> list = criteria.list();
		for (Drug drug:list) {
			compStock.setDrugstoreid(3);
			compStock.setDid(drug.getDid()); 
			compStock.setDname(drug.getDname());
			session.save(compStock);
		}
		tx.commit();
		session.close();
	}

}
