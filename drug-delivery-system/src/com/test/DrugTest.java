package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.entity.Drug;


public class DrugTest {
	private Session session;
	private SessionFactory sf;
	private Transaction tx;

	@Test
	public void customtest() {
		Configuration conf=new Configuration().configure();
		sf=conf.buildSessionFactory();
		session=sf.openSession();
		tx=session.beginTransaction();
		//*********************************************************
		Drug d=new Drug(3, "京都念慈菴蜜炼川贝枇杷膏300ml润肺止咳糖浆感冒咳嗽药", 0,0,0,36, "/web_pic/5aefb5e0N89d81efc.jpg","品牌： 京都念慈菴\r\n" + 
				"商品名称：京都念慈菴蜜炼川贝枇杷膏商品编号：3119481商品毛重：0.715kg商品产地：香港药品类别：中药药品剂型：其他症状：咳嗽适用人群：不限适用类型：有痰咳嗽，其它\r\n"  
				, 39.8,"true");
		session.save(d);
		//*************************************************************
		tx.commit();
		session.close();
		sf.close();
	}

}
