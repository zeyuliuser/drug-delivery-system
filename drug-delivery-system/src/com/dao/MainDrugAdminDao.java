package com.dao;

import java.util.List;

import com.entity.MainDrugAdmin;

public interface MainDrugAdminDao {

	MainDrugAdmin searchByAdmin(String username);

	List<MainDrugAdmin> getAll();

	void save(String madmin, String mpassword, String mrname);

}
