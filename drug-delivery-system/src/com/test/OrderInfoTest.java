package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.entity.OrderInfo;
import com.util.OrderDispatcherUtil;

public class OrderInfoTest {

	/*@Test
	public void addOrderInfo(){
		Configuration configuration= new Configuration().configure();
		SessionFactory sf= configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		OrderInfo of = new OrderInfo(1, 2, 1, "唐山", "13824811566", 2, "", 69, 2, "admin", "北京", "18811362544", 2, "美食特棒", "日本",3);
		session.save(of);
		tx.commit();
		sf.close();
		session.close();
	}
	@Test
	public void dispatcherOrderTest() {
		OrderDispatcherUtil oUtil = new OrderDispatcherUtil();
		int i = oUtil.dispatcherOrder("北京市朝阳区北沙滩1号");
		System.out.println(i);
	}
	*/
	@Test
	public void getstatebetween() {
		Configuration configuration= new Configuration().configure();
		SessionFactory sf= configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderInfo.class);
		criteria.add(Restrictions.between("state", 0, 1));
		List<OrderInfo> infos = criteria.list();
		for(OrderInfo list:infos) {
			System.out.println(list.getState());
		}
		tx.commit();
		sf.close();
		session.close();
	}
}
