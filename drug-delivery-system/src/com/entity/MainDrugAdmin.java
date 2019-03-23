package com.entity;

public class MainDrugAdmin {
	private int mid;
	private String madmin;
	private String mpassword;
	private String mrname;
			
	public MainDrugAdmin() {
	}

	public MainDrugAdmin(int mid, String madmin, String mpassword, String mrname) {
		super();
		this.mid = mid;
		this.madmin = madmin;
		this.mpassword = mpassword;
		this.mrname = mrname;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMadmin() {
		return madmin;
	}
	public void setMadmin(String madmin) {
		this.madmin = madmin;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMrname() {
		return mrname;
	}
	public void setMrname(String mrname) {
		this.mrname = mrname;
	}
	

}
