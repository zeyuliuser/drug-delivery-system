package com.entity;

public class CustomCart {
	private int id;
	private int cid;
	private String dname;
	private int did;
	private int num;
	private double price;
	private double amount;

	public CustomCart() {

	}

	public CustomCart(int id, int cid,String dname, int did, int num, double price) {
		this.id = id;
		this.cid = cid;
		this.dname =dname;
		this.did = did;
		this.num = num;
		this.price = price;
		this.amount= num*price;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		amount =num*price;
		return amount;
	}

	public void setAmount(double amount) {
		amount =num*price;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}
