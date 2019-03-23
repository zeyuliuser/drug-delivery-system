package com.entity;

public class Drug {
	private int did;
	
	private String dname;
	
	private String firstclass;
	
	private String secondclass;
	
	private String thirdclass;
	
	private double size_length_cm;
	
	private double size_width_cm;
	
	private double size_high_cm;
	
	private double weigth_g;
	
	private String dpic;
	
	private String ddesc;
	
	private double price;
	
	private String isrx;
	
	public Drug() {
	}
	
	

	/*
	 * 
	 * public Drug(int did, String dname, String firstclass, String secondclass, String thirdclass, double size_length_cm,
			double size_width_cm, double size_high_cm, double weigth_g, String dpic, String ddesc, double price) {
		super();
		this.did = did;
		this.dname = dname;
		this.firstclass = firstclass;
		this.secondclass = secondclass;
		this.thirdclass = thirdclass;
		this.size_length_cm = size_length_cm;
		this.size_width_cm = size_width_cm;
		this.size_high_cm = size_high_cm;
		this.weigth_g = weigth_g;
		this.dpic = dpic;
		this.ddesc = ddesc;
		this.price = price;
	}
*/


	public Drug(int did, String dname, double size_length_cm, double size_width_cm, double size_high_cm, double weigth_g,
			String dpic, String ddesc, double price,String isrx) {
		this.did = did;
		this.dname = dname;
		this.size_length_cm = size_length_cm;
		this.size_width_cm = size_width_cm;
		this.size_high_cm = size_high_cm;
		this.weigth_g = weigth_g;
		this.dpic = dpic;
		this.ddesc = ddesc;
		this.price = price;
		this.setIsrx(isrx);
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

	public double getSize_length_cm() {
		return size_length_cm;
	}

	public void setSize_length_cm(double string) {
		this.size_length_cm = string;
	}

	public double getSize_width_cm() {
		return size_width_cm;
	}

	public void setSize_width_cm(double size_width_cm) {
		this.size_width_cm = size_width_cm;
	}

	public double getSize_high_cm() {
		return size_high_cm;
	}

	public void setSize_high_cm(double string) {
		this.size_high_cm = string;
	}

	public double getWeigth_g() {
		return weigth_g;
	}

	public void setWeigth_g(double weigth_g) {
		this.weigth_g = weigth_g;
	}

	public String getDpic() {
		return dpic;
	}

	public void setDpic(String dpic) {
		this.dpic = dpic;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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



	public String getIsrx() {
		return isrx;
	}



	public void setIsrx(String isrx) {
		this.isrx = isrx;
	}






	
	
	

}
