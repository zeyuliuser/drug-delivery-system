package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.LogisticAdmin;
import com.entity.MainDrugAdmin;

import com.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class MainDrugAdminDaoImpl implements MainDrugAdminDao {

	@SuppressWarnings("unchecked")
	@Override
	public MainDrugAdmin searchByAdmin(String username) {
		Session session = HibernateUtil.openSession();	   
	    @SuppressWarnings("rawtypes")
		Query q = session.createQuery("from MainDrugAdmin m where m.madmin=?");
		q.setParameter(0, username);
		List<MainDrugAdmin> list =q.list();   
	    if (list.toString() != "[]") {
		    MainDrugAdmin maindrugadmin=session.get(MainDrugAdmin.class, list.get(0).getMid());		 
		    return maindrugadmin;
		} else {

			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MainDrugAdmin> getAll() {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria =session.createCriteria(MainDrugAdmin.class);
		List<MainDrugAdmin> mainDrugAdmin=criteria.list();
		tx.commit();
		session.close();
		return mainDrugAdmin;
	}

	@Override
	public void save(String madmin, String mpassword, String mrname) {
		MainDrugAdmin mainDrugAdmin =new MainDrugAdmin();
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		mainDrugAdmin.setMadmin(madmin);
		mainDrugAdmin.setMpassword(mpassword);
		mainDrugAdmin.setMrname(mrname);
		session.save(mainDrugAdmin);
		tx.commit();
		session.close();
		
	}

}
