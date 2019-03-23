package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.entity.Car;
import com.util.HibernateUtil;

public class CarTest {
	@Test
	public void CarSaveTest() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Car car =new Car("京q a21u5", "老司机", 0, "华北电力大学");
		session.save(car);
		tx.commit();
		session.close();
		
	}

}
