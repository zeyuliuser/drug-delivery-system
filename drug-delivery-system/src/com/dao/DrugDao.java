package com.dao;

import java.util.List;

import com.entity.CustomCart;
import com.entity.Drug;

public interface DrugDao {

	List<Drug> getAllDrug();

	List<Drug> getSpecialAllDrug(String s);

	void save(Drug drug);


	List<CustomCart> getCustomCartByDidAndCid(int did, int cid);

	void updateCustomCart(int did, int cid, int num, double d);

	void createCart(int did, int num, int cid, double price, String dname);

	Drug getDrugByDid(int did);

	List<CustomCart> getCartByCid(int cid);

	void deleteCart(int id);

	void deleteDrugByDid(int did);

	List<Drug> SearchDrugByName(String dname);

	List<Drug> findDrugByClass(String firstclass, String secondclass, String thirdclass);

	void saveDrugByList(List<Drug> list);

	boolean searchCartIfIsrxByCid(int cid);

}
