package com.entity;

public class CompStock {
	private int id;
	
	private int drugstoreid;
	
	private int did;
	
	private String dname;
	
	private int stocknum;
	
	

	public CompStock() {
	
	}



	public CompStock(int id,int drugstoreid, int did, String dname, int stocknum) {
		this.setId(id);
		this.drugstoreid = drugstoreid;
		this.did = did;
		this.dname = dname;
		this.stocknum = stocknum;
	}



	public int getDrugstoreid() {
		return drugstoreid;
	}



	public void setDrugstoreid(int drugstoreid) {
		this.drugstoreid = drugstoreid;
	}



	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public int getStocknum() {
		return stocknum;
	}



	public void setStocknum(int stocknum) {
		this.stocknum = stocknum;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	

}
