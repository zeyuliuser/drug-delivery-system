package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.entity.CustomCart;
import com.entity.Drug;
import com.util.HibernateUtil;

public class DrugDaoImpl implements DrugDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> getAllDrug() {
		Session session = HibernateUtil.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Drug.class);
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> getSpecialAllDrug(String s) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Drug.class);
		criteria.add(Restrictions.eq("dname", s));
		
		return criteria.list();
	}

	@Override
	public void save(Drug drug) {
		Session session = HibernateUtil.openSession();
		Transaction tx =session.beginTransaction();
		session.save(drug);
		tx.commit();
		session.close();
		
	}



	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<CustomCart> getCustomCartByDidAndCid(int did, int cid) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("did", did));
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		List<CustomCart> list =criteria.list();
		tx.commit();
		session.close();
		return list;
		
	}

	@Override
	public void updateCustomCart(int id, int num, int i, double d) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		CustomCart cart=session.get(CustomCart.class, id);
		cart.setNum(num+i);
		cart.setAmount(d*(i+num));
		session.update(cart);
		tx.commit();
		session.close();
		
	}

	@Override
	public void createCart(int did, int num, int cid, double price,String dname) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		CustomCart cart = new CustomCart();
		cart.setCid(cid);
		cart.setDid(did);
		cart.setNum(num);
		cart.setPrice(price);
		cart.setAmount(num*price);
		cart.setDname(dname);
		session.save(cart);
		tx.commit();
		session.close();
		
	}

	@Override
	public Drug getDrugByDid(int did) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Drug drug=session.get(Drug.class, did);
		tx.commit();
		session.close();
		return drug;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<CustomCart> getCartByCid(int cid) {
		Session session =HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		return criteria.list();
		
	}

	@Override
	public void deleteCart(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		CustomCart cart = session.get(CustomCart.class, id);
		session.delete(cart);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public void deleteDrugByDid(int did) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Drug drug = new Drug();
		drug = session.get(Drug.class, did);
		session.delete(drug);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Drug> SearchDrugByName(String dname) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Query query= session.createQuery("from Drug d where d.dname = ?");
		query.setParameter(0, dname);
		List<Drug> list = query.list();
		System.out.println(list.toString());
		tx.commit();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> findDrugByClass(String firstclass, String secondclass, String thirdclass) {
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Drug.class);
		criteria.add(Restrictions.eqOrIsNull("firstclass", firstclass));
		criteria.add(Restrictions.eqOrIsNull("secondclass", secondclass));
		criteria.add(Restrictions.eqOrIsNull("thirdclass", thirdclass));
		List<Drug> list = criteria.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void saveDrugByList(List<Drug> list) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		for(Drug drug:list) {
			session.save(drug);
		}
		tx.commit();
		session.close();
	}

	@Override
	public boolean searchCartIfIsrxByCid(int cid) {
		boolean isRx = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CustomCart.class);
		criteria.add(Restrictions.eqOrIsNull("cid", cid));
		List<CustomCart> carts = criteria.list();
		for(CustomCart cart:carts) {
			Drug drug = session.get(Drug.class, cart.getDid());
			System.out.println(drug.getIsrx());
			if(drug.getIsrx().equals("TRUE")) {
				isRx = true;
				
			}
		}
		tx.commit();
		session.close();
		return isRx;
	}

}
