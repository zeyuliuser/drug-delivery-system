package com.entity;

import com.util.GetLocationUtil;

public class DrugStoreInfo {
	private int drugstoreid;
	
	private String saddress;
	
	private double drugstore_x;
	
	private double drugstore_y;
	
	

	public DrugStoreInfo() {
	}



	public DrugStoreInfo(String saddress) {
		GetLocationUtil getLocationUtil = new GetLocationUtil(saddress);
		this.saddress = saddress;
		this.drugstore_x = getLocationUtil.getX();
		this.drugstore_y = getLocationUtil.getY();
		
	}



	public int getDrugstoreid() {
		return drugstoreid;
	}



	public void setDrugstoreid(int drugstoreid) {
		this.drugstoreid = drugstoreid;
	}



	public String getSaddress() {
		return saddress;
	}



	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}



	public double getDrugstore_x() {
		return drugstore_x;
	}



	public void setDrugstore_x(double drugstore_x) {
		this.drugstore_x = drugstore_x;
	}



	public double getDrugstore_y() {
		return drugstore_y;
	}



	public void setDrugstore_y(double drugstore_y) {
		this.drugstore_y = drugstore_y;
	}
	
	

}
