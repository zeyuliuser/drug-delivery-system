package com.entity;

public class DrugClassMotify {
	
	private int dcid;
	
	private String firstclass;
	
	private String secondclass;
	
	private String thirdclass;
	
	public DrugClassMotify() {
	
	}

	public DrugClassMotify(int dcid, String firstclass, String secondclass, String thirdclass) {
		this.dcid = dcid;
		this.firstclass = firstclass;
		this.secondclass = secondclass;
		this.thirdclass = thirdclass;
	}

	public int getDcid() {
		return dcid;
	}

	public void setDcid(int dcid) {
		this.dcid = dcid;
	}

	public String getFirstclass() {
		return firstclass;
	}

	public void setFirstclass(String firstclass) {
		this.firstclass = firstclass;
	}

	public String getSecondclass() {
		return secondclass;
	}

	public void setSecondclass(String secondclass) {
		this.secondclass = secondclass;
	}

	public String getThirdclass() {
		return thirdclass;
	}

	public void setThirdclass(String thirdclass) {
		this.thirdclass = thirdclass;
	}	

}
