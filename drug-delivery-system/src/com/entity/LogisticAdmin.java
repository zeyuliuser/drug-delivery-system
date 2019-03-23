package com.entity;

public class LogisticAdmin {
	private int lid;
	
	private int staffid;
	
	private String lusername;
	
	private String lpassword;
	
	private String laddress;
	
	private String lrname;
	
	private String lgender;
	
	private String lphone;
	
	

	public LogisticAdmin() {
		
	}
	
	

	public LogisticAdmin(int lid, int staffid, String lusername, String lpassword, String laddress, String lrname,
			String lgender, String lphone) {
		this.lid = lid;
		this.staffid = staffid;
		this.lusername = lusername;
		this.lpassword = lpassword;
		this.laddress = laddress;
		this.lrname = lrname;
		this.lgender = lgender;
		this.lphone = lphone;
	}



	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getLusername() {
		return lusername;
	}

	public void setLusername(String lusername) {
		this.lusername = lusername;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public String getLaddress() {
		return laddress;
	}

	public void setLaddress(String laddress) {
		this.laddress = laddress;
	}

	public String getLrname() {
		return lrname;
	}

	public void setLrname(String lrname) {
		this.lrname = lrname;
	}

	public String getLgender() {
		return lgender;
	}

	public void setLgender(String lgender) {
		this.lgender = lgender;
	}

	public String getLphone() {
		return lphone;
	}

	public void setLphone(String lphone) {
		this.lphone = lphone;
	}
	
	

}
