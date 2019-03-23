package com.entity;


public class Custom {
	private Integer cid;

	private String username;

	private String realname;

	private String password;

	private String cgender;

	private String phone;

	public Custom() {
	}

	public Custom(Integer cid, String username, String realname, String password, String cgender, String phone) {
		this.cid = cid;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.cgender = cgender;
		this.phone = phone;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

}
