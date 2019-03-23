package com.Impl;

import java.util.List;

import com.dao.DrugClassMotifyDao;
import com.dao.DrugClassMotifyDaoImpl;
import com.entity.DrugClassMotify;
import com.service.DrugClassMotifyService;


public class DrugClassMotifyServiceImpl implements DrugClassMotifyService {
	DrugClassMotifyDao dcmd = new DrugClassMotifyDaoImpl();

	@Override
	public List<DrugClassMotify> searchSecondClass(String firstclass) {
		
		return dcmd.searchSecondClass(firstclass);
	}

}
