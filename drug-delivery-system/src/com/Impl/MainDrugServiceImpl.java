package com.Impl;

import java.util.List;

import com.dao.MainDrugAdminDao;
import com.dao.MainDrugAdminDaoImpl;
import com.entity.MainDrugAdmin;
import com.service.MainDrugService;

public class MainDrugServiceImpl implements MainDrugService {

	@Override
	public MainDrugAdmin searchByAdmin(String username) {
		MainDrugAdminDao madao=new MainDrugAdminDaoImpl();
		return madao.searchByAdmin(username);
	}

	@Override
	public List<MainDrugAdmin> getAll() {
		MainDrugAdminDao madao=new MainDrugAdminDaoImpl();

		return madao.getAll();
	}

	@Override
	public void save(String madmin, String mpassword, String mrname) {
		MainDrugAdminDao madao=new MainDrugAdminDaoImpl();
		madao.save(madmin,mpassword,mrname);
	}

}
