package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Car;
import com.entity.LogisticAdmin;
import com.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class LogisticAdminDaoImpl implements LogisticAdminDao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public LogisticAdmin searchByAdmin(String username) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
	   
		Query q = session.createQuery("from LogisticAdmin l where l.lusername=?");
		q.setParameter(0, username);
		List<LogisticAdmin> list =q.list();	  	    
	    if (list.toString() != "[]") {
	    	LogisticAdmin lAdmin=session.get(LogisticAdmin.class, list.get(0).getLid());
			return lAdmin;
		} else {

			return null;
		}
	}

	@Override
	public List<LogisticAdmin> getAll() {
		Session session = HibernateUtil.openSession();
	    Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(LogisticAdmin.class);
	    List<LogisticAdmin> list = criteria.list();
	    tx.commit();
	    session.close();
		return list;
	}

	@Override
	public void saveAdmin(String lusername, String lpassword, String lrname, String laddress, String lphone,
			String lgender) {
		LogisticAdmin admin = new LogisticAdmin();
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		admin.setLusername(lusername);
		admin.setLpassword(lpassword);
		admin.setLrname(lrname);
		admin.setLaddress(laddress);
		admin.setLphone(lphone);
		admin.setLgender(lgender);
		session.save(admin);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getAllCar() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Car.class);
		List<Car> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void saveCar(String carid, String driver, int carstate, String caraddress) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Car car = new Car(carid,driver,carstate,caraddress);	
		session.save(car);
		tx.commit();
		session.close();
	}

	@Override
	public void repairCar(String carid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Car car = session.get(Car.class, carid);
		car.setCarstate(-1);
		session.update(car);
		tx.commit();
		session.close();		
	}

	@Override
	public void repairedCar(String carid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Car car = session.get(Car.class, carid);
		car.setCarstate(0);
		session.update(car);
		tx.commit();
		session.close();
		
	}

	@Override
	public void setCarFree(String carid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Car car = session.get(Car.class, carid);
		car.setCarstate(0);
		session.update(car);
		tx.commit();
		session.close();
		
	}

}
