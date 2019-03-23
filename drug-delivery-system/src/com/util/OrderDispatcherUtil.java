package com.util;

import java.util.List;

import com.Impl.DrugStoreServiceImpl;
import com.entity.DrugStoreInfo;
import com.service.DrugStoreService;


public class OrderDispatcherUtil {
	
	private int drugstoreid;
	
	public List<DrugStoreInfo> getAllDrugStoreInfo() {
	DrugStoreService drugStoreInfo= new DrugStoreServiceImpl();
	List<DrugStoreInfo> drugStoreInfos=drugStoreInfo.getAllDrugStoreInfo();
	return drugStoreInfos;	
	}
	
	public int dispatcherOrder(String address){		
		OrderDispatcherUtil orderDispatcherUtil = new OrderDispatcherUtil();
		List<DrugStoreInfo> drugStoreInfos = orderDispatcherUtil.getAllDrugStoreInfo();
		GetLocationUtil gUtil= new GetLocationUtil(address);
		double custom_x=gUtil.getX();
		double custom_y=gUtil.getY();
		double d = (custom_x-drugStoreInfos.get(0).getDrugstore_x())*(custom_x-drugStoreInfos.get(0).getDrugstore_x())+(custom_y-drugStoreInfos.get(0).getDrugstore_y())*(custom_y-drugStoreInfos.get(0).getDrugstore_y());
		int i=drugStoreInfos.get(0).getDrugstoreid();
		for(DrugStoreInfo dinfo:drugStoreInfos) {
			double t = (custom_x-dinfo.getDrugstore_x())*(custom_x-dinfo.getDrugstore_x())+(custom_y-dinfo.getDrugstore_y())*(custom_y-dinfo.getDrugstore_y());
			int y = dinfo.getDrugstoreid();
			if(d<=t) {}
			else {
		    	d = t;
		    	i = y;
		    }
			
		}
		drugstoreid = i;
		return drugstoreid;
	}

}
