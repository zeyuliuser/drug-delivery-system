package com.test;

import org.junit.Test;

import com.util.GetLocationUtil;

public class LocationTest {
	@Test
	public void locationTry() {

		
			GetLocationUtil getLocationUtil = new GetLocationUtil("北京市昌平区回龙观北农路2号");
		
			System.out.println(getLocationUtil.getX());
			System.out.println(getLocationUtil.getY());
		

		
	}

}
