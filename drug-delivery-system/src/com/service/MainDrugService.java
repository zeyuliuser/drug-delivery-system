package com.service;

import java.util.List;

import com.entity.MainDrugAdmin;

public interface MainDrugService {

	MainDrugAdmin searchByAdmin(String username);

	List<MainDrugAdmin> getAll();

	void save(String madmin, String mpassword, String mrname);

}
