package com.dao;

import java.util.List;

import com.entity.DrugStore;
import com.entity.DrugStoreInfo;

public interface DrugStoreDao {

	DrugStore searchByAdmin(String username);

	List<DrugStore> getAllDrugStore();

	void saveFAdmin(String sname, String spassword, String srname, String saddress, String sphone, String sgender);

	List<DrugStoreInfo> getAllDrugStoreInfo();

}
