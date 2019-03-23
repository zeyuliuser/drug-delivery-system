package com.entity;

public class Car {
	private String carid;
	private String driver;
	private int carstate; //-1修理中  0空闲  1正在使用
	private String caraddress;
	
	
	public Car() {
	}


	public Car(String carid, String driver, int carstate, String caraddress) {
		super();
		this.carid = carid;
		this.driver = driver;
		this.carstate = carstate;
		this.caraddress = caraddress;
	}


	public String getCarid() {
		return carid;
	}


	public void setCarid(String carid) {
		this.carid = carid;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public int getCarstate() {
		return carstate;
	}


	public void setCarstate(int carstate) {
		this.carstate = carstate;
	}


	public String getCaraddress() {
		return caraddress;
	}


	public void setCaraddress(String caraddress) {
		this.caraddress = caraddress;
	}
	
	
	
	

}
