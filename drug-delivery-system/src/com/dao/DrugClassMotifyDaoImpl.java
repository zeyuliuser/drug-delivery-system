package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.DrugClassMotify;
import com.util.HibernateUtil;

public class DrugClassMotifyDaoImpl implements DrugClassMotifyDao {

	@Override
	public List<DrugClassMotify> searchSecondClass(String firstclass) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DrugClassMotify.class);
		criteria.add(Restrictions.eqOrIsNull("firstclass", firstclass));
		List<DrugClassMotify> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

}
