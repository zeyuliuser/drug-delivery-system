package com.dao;

import java.util.List;

import com.entity.DrugClassMotify;

public interface DrugClassMotifyDao {

	List<DrugClassMotify> searchSecondClass(String firstclass);

}
