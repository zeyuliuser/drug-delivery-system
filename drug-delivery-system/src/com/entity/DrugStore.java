package com.entity;

public class DrugStore {
	
	private int staffid;
	
	private String sname;
	
	private String spassword;
	
	private String saddress;
	
	private String srname;
	
	private String sphone;
	
	private String sgender;
	
	private int drugstoreid;
	
	public DrugStore() {
	}
	
	
	
	


	public DrugStore(int staffid, String sname, String spassword, String saddress, String srname, String sphone,
			String sgender,int drugstoreid) {
		super();
		this.staffid = staffid;
		this.sname = sname;
		this.spassword = spassword;
		this.saddress = saddress;
		this.srname = srname;
		this.sphone = sphone;
		this.sgender = sgender;
		this.drugstoreid = drugstoreid;
	}






	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSrname() {
		return srname;
	}
	public void setSrname(String srname) {
		this.srname = srname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}






	public int getDrugstoreid() {
		return drugstoreid;
	}






	public void setDrugstoreid(int drugstoreid) {
		this.drugstoreid = drugstoreid;
	}
	
}
