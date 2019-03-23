package com.Impl;

import java.util.List;

import com.dao.LogisticAdminDao;
import com.dao.LogisticAdminDaoImpl;
import com.entity.Car;
import com.entity.LogisticAdmin;
import com.service.LogisticAdminService;
import com.sun.org.apache.bcel.internal.generic.LASTORE;

public class LogisticAdminServiceImpl implements LogisticAdminService {
	LogisticAdminDao lad =new LogisticAdminDaoImpl();

	@Override
	public LogisticAdmin searchByAdmin(String username) {
		// TODO Auto-generated method stub
		return lad.searchByAdmin(username);
	}

	@Override
	public List<LogisticAdmin> getAll() {
		
		return lad.getAll();
	}

	@Override
	public void saveAdmin(String lusername, String lpassword, String lrname, String laddress, String lphone,
			String lgender) {
		LogisticAdminDao lAdminDao = new LogisticAdminDaoImpl();
		lAdminDao.saveAdmin(lusername,lpassword,lrname,laddress,lphone,lgender);
		
	}

	@Override
	public List<Car> getAllCar() {
		// TODO Auto-generated method stub
		return lad.getAllCar();
	}

	@Override
	public void saveCar(String carid, String driver, int carstate, String caraddress) {
		lad.saveCar(carid,driver,carstate,caraddress);
		
	}

	@Override
	public void repairCarById(String carid) {
		// TODO Auto-generated method stub
		lad.repairCar(carid);
	}

	@Override
	public void repairedCarById(String carid) {
		lad.repairedCar(carid);
		
	}

	@Override
	public void setCarFree(String carid) {
		lad.setCarFree(carid);

		
	}

}
