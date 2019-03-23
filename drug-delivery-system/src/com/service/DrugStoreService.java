package com.service;

import java.util.List;

import com.entity.DrugStore;
import com.entity.DrugStoreInfo;

public interface DrugStoreService {

	DrugStore searchByAdmin(String username);

	List<DrugStore> getAllDurgStore();

	void saveFAdmin(String sname, String spassword, String srname, String saddress, String sphone, String sgender);

	List<DrugStoreInfo> getAllDrugStoreInfo();

}
