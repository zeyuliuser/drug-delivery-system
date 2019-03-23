package com.entity;

public class OrderInfo {
	private int oid;//订单编号
	private int state;//-1-拒收  0-待发货  1-进行中(未完成)  2-已完成
	/*顾客信息*/
	private int cid;
	private String address;
	private String phone;
	/*购物车信息*/	
	/*
	 * private int num;
	private String dname;
	private double price;
	private double amount;
	*/
	
	private String odesc;
	private double allamount;
	/*分公司信息*/
	private int id;
	private int staffid;
	private String srname;
	private String saddress;
	private String sphone;
	/*物流信息*/
	private int lid;
	private String lrname;
	private String logisticaddress;
	private String carid;
	/*处方药*/
	private int isrx;
	private String webpic;
	
	
	public OrderInfo() {
	
	}

	public OrderInfo(int oid, int state, int cid, String address, String phone, int id, String odesc, double allamount,
			int staffid, String srname, String saddress, String sphone, int lid, String lrname,
			String logisticaddress,String carid,int isrx, String webpic) {
		this.oid = oid;
		this.state = state;
		this.cid = cid;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.setOdesc(odesc);
		this.allamount = allamount;
		this.staffid = staffid;
		this.srname = srname;
		this.saddress = saddress;
		this.sphone = sphone;
		this.lid = lid;
		this.lrname = lrname;
		this.logisticaddress = logisticaddress;
		this.carid = carid;
		this.isrx = isrx;
		this.webpic = webpic;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public double getAllamount() {
		return allamount;
	}

	public void setAllamount(double allamount) {
		this.allamount = allamount;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLrname() {
		return lrname;
	}

	public void setLrname(String lrname) {
		this.lrname = lrname;
	}

	public String getLogisticaddress() {
		return logisticaddress;
	}

	public void setLogisticaddress(String logisticaddress) {
		this.logisticaddress = logisticaddress;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getOdesc() {
		return odesc;
	}

	public void setOdesc(String odesc) {
		this.odesc = odesc;
	}

	public int getIsrx() {
		return isrx;
	}

	public void setIsrx(int isrx) {
		this.isrx = isrx;
	}

	public String getWebpic() {
		return webpic;
	}

	public void setWebpic(String webpic) {
		this.webpic = webpic;
	}
	
	
	
	

}
