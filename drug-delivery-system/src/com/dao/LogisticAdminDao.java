package com.dao;

import java.util.List;

import com.entity.Car;
import com.entity.LogisticAdmin;

public interface LogisticAdminDao {

	LogisticAdmin searchByAdmin(String username);

	List<LogisticAdmin> getAll();

	void saveAdmin(String lusername, String lpassword, String lrname, String laddress, String lphone, String lgender);

	List<Car> getAllCar();

	void saveCar(String carid, String driver, int carstate, String caraddress);

	void repairCar(String carid);

	void repairedCar(String carid);

	void setCarFree(String carid);

}
