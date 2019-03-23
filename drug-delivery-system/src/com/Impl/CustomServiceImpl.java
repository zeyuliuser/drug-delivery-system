package com.Impl;

import com.dao.CustomDao;
import com.dao.CustomDaoImpl;
import com.entity.Custom;
import com.service.CustomService;

public class CustomServiceImpl implements CustomService {
	private CustomDao customdao = new CustomDaoImpl();

	@Override
	public void save(Custom c) {
		// TODO Auto-generated method stub
        //调用dao保存客户
		customdao.save(c);
	};
	public boolean checkexist(String username) {
		return customdao.checkexist(username);
	};
	public Custom searchByUsername(String username) {
		return customdao.searchByUsername(username);
	}
	@Override
	public void updateCustomById(int i, String username, String password, String cgender, String realname,
			String phone) {
	 customdao.updateCustomById(i,username,password,cgender,realname,phone);
		
	}

}
