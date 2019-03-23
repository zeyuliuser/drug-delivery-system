package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.DrugStore;
import com.entity.DrugStoreInfo;
import com.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class DrugStoreDaoImpl implements DrugStoreDao {

	@SuppressWarnings("unchecked")
	@Override
	public DrugStore searchByAdmin(String username) {
		Session session = HibernateUtil.openSession();
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery("from DrugStore c where c.sname=?");
		q.setParameter(0, username);
		List<DrugStore> list = q.list();

		if (list.toString() != "[]") {
			DrugStore dStore = session.get(DrugStore.class, list.get(0).getStaffid());
			return dStore;
		} else {

			return null;
		}

	}

	@Override
	public List<DrugStore> getAllDrugStore() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DrugStore.class);
		List<DrugStore> list = criteria.list();
		tx.commit();
		session.close();
		return list;

	}

	@Override
	public void saveFAdmin(String sname, String spassword, String srname, String saddress, String sphone,
			String sgender) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		DrugStore drugStore = new DrugStore();
		drugStore.setSname(sname);
		drugStore.setSpassword(spassword);
		drugStore.setSrname(srname);
		drugStore.setSaddress(saddress);
		drugStore.setSphone(sphone);
		drugStore.setSgender(sgender);
		Criteria criteria = session.createCriteria(DrugStoreInfo.class);
		criteria.add(Restrictions.eqOrIsNull("saddress", saddress));
		@SuppressWarnings("unchecked")
		List<DrugStoreInfo> list = criteria.list();
		System.out.println(list.toString());
		if (list.toString() != "[]") {
			drugStore.setDrugstoreid(list.get(0).getDrugstoreid());
		} else {
			DrugStoreInfo drugStoreInfo = new DrugStoreInfo(saddress);
			session.save(drugStoreInfo);
			criteria.add(Restrictions.eqOrIsNull("saddress", saddress));
			List<DrugStoreInfo> list2 = criteria.list();
			drugStore.setDrugstoreid(list2.get(0).getDrugstoreid());
		}

		session.save(drugStore);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DrugStoreInfo> getAllDrugStoreInfo() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DrugStoreInfo.class);
		List<DrugStoreInfo> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}
}
