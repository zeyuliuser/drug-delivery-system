package com.Impl;

import java.util.List;

import com.dao.DrugStoreDao;
import com.dao.DrugStoreDaoImpl;
import com.entity.DrugStore;
import com.entity.DrugStoreInfo;
import com.service.DrugStoreService;

public class DrugStoreServiceImpl implements DrugStoreService {
	DrugStoreDao dsd =new DrugStoreDaoImpl();

	@Override
	public DrugStore searchByAdmin(String username) {
		// TODO Auto-generated method stub
		return dsd.searchByAdmin(username);
	}

	@Override
	public List<DrugStore> getAllDurgStore() {
		
		return dsd.getAllDrugStore();
	}

	@Override
	public void saveFAdmin(String sname, String spassword, String srname, String saddress, String sphone,
			String sgender) {
		dsd.saveFAdmin(sname,spassword,srname,saddress,sphone,sgender);
		
	}

	@Override
	public List<DrugStoreInfo> getAllDrugStoreInfo() {
		// TODO Auto-generated method stub
		return dsd.getAllDrugStoreInfo();
	}

}
