package com.service;

import com.entity.Custom;

public interface CustomService {
	void save(Custom c);
	boolean checkexist(String username);
	Custom searchByUsername(String username);
	void updateCustomById(int i, String username, String password, String cgender, String realname, String phone);
}
