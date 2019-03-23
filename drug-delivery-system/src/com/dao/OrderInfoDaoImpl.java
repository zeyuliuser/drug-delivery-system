package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import com.entity.Car;
import com.entity.CustomCart;
import com.entity.DrugStore;
import com.entity.DrugStoreInfo;
import com.entity.LogisticAdmin;
import com.entity.OrderInfo;
import com.util.HibernateUtil;
import com.util.OrderDispatcherUtil;

public class OrderInfoDaoImpl implements OrderInfoDao {

	@Override
	public void saveOrderInfoByCid(int cid,String address,String phone) {
		OrderDispatcherUtil orderDispatcherUtil = new OrderDispatcherUtil();
		String odesc = "";
		double allamount = 0 ;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = new OrderInfo();
		oInfo.setState(0);
		oInfo.setCid(cid);
		oInfo.setAddress(address);
		int id=orderDispatcherUtil.dispatcherOrder(address);
		String saddress=session.get(DrugStoreInfo.class, id).getSaddress();
		oInfo.setSaddress(saddress);
		oInfo.setId(id);
		oInfo.setPhone(phone);		
		@SuppressWarnings("deprecation")
		Criteria criteria =session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		@SuppressWarnings("unchecked")
		List<CustomCart> list=criteria.list();
		for(CustomCart c:list) {
			odesc = odesc +"药品名称：" + c.getDname() +"购买数量："+c.getNum() +"药品单价："+c.getPrice()+"\n";
			allamount = allamount + c.getAmount();
		}
		odesc = odesc + "\n 药品总价：" + allamount;
		oInfo.setAllamount(allamount);
		oInfo.setOdesc(odesc);
		oInfo.setIsrx(0);
		
		for(CustomCart c:list) {
			session.delete(c);			
		}
		session.save(oInfo);		
		tx.commit();
		session.close();
	}

	@Override
	public List<OrderInfo> getOrderInfoByCidAndState(int cid, int i) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderInfo.class);
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		criteria.add(Restrictions.eqOrIsNull("state", i));
		List<OrderInfo> list = criteria.list();
		tx.commit();
		session.close();
		
		return list;
	}

	@Override
	public void updateStateToCancel(int oid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = session.get(OrderInfo.class, oid);
		oInfo.setState(-1);
		session.update(oInfo);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<OrderInfo> getUnfinishOrder() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderInfo.class);
		criteria.add(Restrictions.between("state", 0, 1));
		List<OrderInfo> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<OrderInfo> getUnAcceptOrder() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderInfo.class);
		criteria.add(Restrictions.eqOrIsNull("state", -1));
		List<OrderInfo> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<OrderInfo> getAllFinishDrugToZcomp() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderInfo.class);
		criteria.add(Restrictions.eqOrIsNull("state", 2));
		List<OrderInfo> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public OrderInfo getOrderByOid(int oid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo orderInfo = session.get(OrderInfo.class, oid);
		tx.commit();
		session.close();
		return orderInfo;
	}

	@Override
	public List<OrderInfo> getOrderInfoByDrugStoreIdAndState(int drugstoreid, int i) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(OrderInfo.class);
	    criteria.add(Restrictions.eqOrIsNull("id", drugstoreid));
	    criteria.add(Restrictions.eqOrIsNull("state", i));
	    List<OrderInfo> list = criteria.list();
	    tx.commit();
	    session.close();
		if (list.toString()!="[]") {
			return list;
			
		}else {
			return null;
		}
	}

	@Override
	public void updateOrderInfoByStaffid(int staffid, int oid, int lid) {
		OrderInfo oInfo = new OrderInfo();
		DrugStore dStore = new DrugStore();
		LogisticAdmin lAdmin = new LogisticAdmin();
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		oInfo = session.get(OrderInfo.class, oid);
		dStore = session.get(DrugStore.class, staffid);
		lAdmin = session.get(LogisticAdmin.class, lid);
		oInfo.setStaffid(staffid);
		oInfo.setSrname(dStore.getSrname());
		oInfo.setSphone(dStore.getSphone());
		oInfo.setLid(lid);
		oInfo.setLrname(lAdmin.getLrname());
		oInfo.setLogisticaddress("已发货，等待分配车辆");
		oInfo.setState(1);
		session.update(oInfo);
		tx.commit();
		session.close();
	}

	@Override
	public List<OrderInfo> getOrderInfoByLidAndState(int lid, int i) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(OrderInfo.class);
	    criteria.add(Restrictions.eqOrIsNull("lid", lid));
	    criteria.add(Restrictions.eqOrIsNull("state", i));
	    List<OrderInfo> list = criteria.list();
	    tx.commit();
	    session.close();
		if (list.toString()!="[]") {
			return list;
			
		}else {
			return null;
		}
	}

	@Override
	public List<OrderInfo> searchUnDispatcherCarOrderByLid(int lid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(OrderInfo.class);
	    criteria.add(Restrictions.eqOrIsNull("lid", lid));
	    criteria.add(Restrictions.eqOrIsNull("state", 1));
	    criteria.add(Restrictions.eqOrIsNull("carid", null));
	    List<OrderInfo> list = criteria.list();
	    tx.commit();
	    session.close();
	    if (list.toString()!="[]") {
			return list;
			
		}else {
			return null;
		}
	}

	@Override
	public void updateOrderWithCarid(int oid, String carid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = new OrderInfo();
		oInfo = session.get(OrderInfo.class, oid);
		oInfo.setCarid(carid);
		session.update(oInfo);
		Car car = session.get(Car.class, carid);
		car.setCarstate(1);
		session.update(car);
		tx.commit();
		session.close();			
	}

	@Override
	public List<OrderInfo> getUnFinishOrderInfoByLid(int lid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
	    Criteria criteria = session.createCriteria(OrderInfo.class);
	    criteria.add(Restrictions.eqOrIsNull("lid", lid));
	    criteria.add(Restrictions.eqOrIsNull("state", 1));
	    criteria.add(Restrictions.not(Expression.eqOrIsNull("carid", null)));
	    List<OrderInfo> list = criteria.list();
	    tx.commit();
	    session.close();
	    if (list.toString()!="[]") {
			return list;
			
		}else {
			return null;
		}
	}

	@Override
	public void updateLogisticaddress(int oid, String logisticaddress) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = new OrderInfo();
		oInfo = session.get(OrderInfo.class, oid);
		oInfo.setLogisticaddress(logisticaddress);
		session.update(oInfo);
		tx.commit();
		session.close();	
		
	}

	@Override
	public void updateStateToSayGoodByeToThisSystem(int oid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = new OrderInfo();
		oInfo = session.get(OrderInfo.class, oid);
	    oInfo.setState(2);
		session.update(oInfo);
		tx.commit();
		session.close();	
		
	}

	@Override
	public void saveHaverxOrderInfoByCid(int cid, String address, String phone, String name) {
		OrderDispatcherUtil orderDispatcherUtil = new OrderDispatcherUtil();
		String odesc = "";
		double allamount = 0 ;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = new OrderInfo();
		oInfo.setState(0);
		oInfo.setCid(cid);
		oInfo.setAddress(address);
		int id=orderDispatcherUtil.dispatcherOrder(address);
		String saddress=session.get(DrugStoreInfo.class, id).getSaddress();
		oInfo.setSaddress(saddress);
		oInfo.setId(id);
		oInfo.setPhone(phone);		
		@SuppressWarnings("deprecation")
		Criteria criteria =session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		@SuppressWarnings("unchecked")
		List<CustomCart> list=criteria.list();
		for(CustomCart c:list) {
			odesc = odesc +"药品名称：" + c.getDname() +"购买数量："+c.getNum() +"药品单价："+c.getPrice()+"\n";
			allamount = allamount + c.getAmount();
		}
		odesc = odesc + "\n 药品总价：" + allamount;
		oInfo.setAllamount(allamount);
		oInfo.setOdesc(odesc);
		oInfo.setIsrx(1);
		oInfo.setWebpic(name);
		
		for(CustomCart c:list) {
			session.delete(c);			
		}
		session.save(oInfo);		
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateUnGoInfo(int oid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		OrderInfo oInfo = session.get(OrderInfo.class, oid);
		oInfo.setLogisticaddress("处方药药方图片审核未通过");
		oInfo.setState(-1);
		tx.commit();
		session.close();
	}

}
