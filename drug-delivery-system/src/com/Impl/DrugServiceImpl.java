package com.Impl;

import java.util.List;

import com.dao.DrugDao;
import com.dao.DrugDaoImpl;
import com.entity.CustomCart;
import com.entity.Drug;
import com.service.DrugService;

public class DrugServiceImpl implements DrugService {

	@Override
	public List<Drug> getAllDrug() {
		DrugDao dd =new DrugDaoImpl();
		return dd.getAllDrug();
	}

	@Override
	public List<Drug> getSpecialAllDrug(String s) {
		// TODO Auto-generated method stub
		DrugDao drugDao =new DrugDaoImpl();
		return drugDao.getSpecialAllDrug(s);
	}

	@Override
	public void save(Drug drug) {
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.save(drug);
		
	}

	



	@Override
	public List<CustomCart> getCustomCartByDidAndCid(int did, int cid) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao.getCustomCartByDidAndCid(did,cid);
	}



	@Override
	public void updateCustomCart(int id, int num, int i, double d) {
		// TODO Auto-generated method stub
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.updateCustomCart(id,num,i,d);
		
	}

	@Override
	public void createCart(int did, int num, int cid, double price,String dname) {
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.createCart(did,num,cid,price,dname);
	}

	@Override
	public Drug getDrugByDid(int did) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao.getDrugByDid(did);
				
	}

	@Override
	public List<CustomCart> getCartByCid(int cid) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao.getCartByCid(cid);
	}

	@Override
	public void deleteCart(int id) {
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.deleteCart(id);
		
	}

	@Override
	public void deleteDrugByDid(int did) {
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.deleteDrugByDid(did);
		
	}

	@Override
	public List<Drug> SearchDrugByName(String dname) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao. SearchDrugByName(dname);
	}

	@Override
	public List<Drug> findDrugByClass(String firstclass, String secondclass, String thirdclass) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao.findDrugByClass(firstclass, secondclass, thirdclass);
	}

	@Override
	public void saveDrugByList(List<Drug> list) {
		DrugDao drugDao = new DrugDaoImpl();
		drugDao.saveDrugByList(list);
		
	}

	@Override
	public boolean searchCartIfIsrxByCid(int cid) {
		DrugDao drugDao = new DrugDaoImpl();
		return drugDao.searchCartIfIsrxByCid(cid);
	}




}
