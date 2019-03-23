package com.Impl;



import java.util.List;

import com.dao.OrderInfoDao;
import com.dao.OrderInfoDaoImpl;
import com.entity.OrderInfo;
import com.service.OrderInfoService;

public class OrderInfoServiceImpl implements OrderInfoService {
	OrderInfoDao oidao = new OrderInfoDaoImpl();

	@Override
	public void saveOrderInfoByCid(int cid, String address, String phone) {
		
		 oidao.saveOrderInfoByCid(cid, address,phone);
	}

	@Override
	public List<OrderInfo> getOrderInfoByCidAndState(int cid, int i) {
		
		return oidao.getOrderInfoByCidAndState(cid,i);
	}

	@Override
	public void updateStateToCancel(int oid) {
		oidao.updateStateToCancel(oid);
		
	}

	@Override
	public List<OrderInfo> getUnfinishOrder() {
		// TODO Auto-generated method stub
		return oidao.getUnfinishOrder();
	}

	@Override
	public List<OrderInfo> getUnAcceptOrder() {
		// TODO Auto-generated method stub
		return oidao.getUnAcceptOrder();
	}

	@Override
	public List<OrderInfo> getAllFinishDrugToZcomp() {
		// TODO Auto-generated method stub
		return oidao.getAllFinishDrugToZcomp();
	}

	@Override
	public OrderInfo getOrderByOid(int oid) {
		// TODO Auto-generated method stub
		return oidao.getOrderByOid(oid);
	}

	@Override
	public List<OrderInfo> getOrderInfoByDrugStoreIdAndState(int drugstoreid, int i) {
		// TODO Auto-generated method stub
		return oidao.getOrderInfoByDrugStoreIdAndState(drugstoreid,i);
	}

	@Override
	public void updateOrderInfoByStaffid(int staffid, int oid, int lid) {
		oidao.updateOrderInfoByStaffid(staffid , oid,  lid);

	}

	@Override
	public List<OrderInfo> getOrderInfoByLidAndState(int lid, int i) {
		// TODO Auto-generated method stub
		return oidao.getOrderInfoByLidAndState(lid,i);
	}

	@Override
	public List<OrderInfo> searchUnDispatcherCarOrderByLid(int lid) {
		// TODO Auto-generated method stub
		return oidao.searchUnDispatcherCarOrderByLid(lid);
	}

	@Override
	public void updateOrderWithCarid(int oid, String carid) {
		oidao.updateOrderWithCarid(oid, carid);
	}

	@Override
	public List<OrderInfo> getUnFinishOrderInfoByLid(int lid) {
		
		return oidao.getUnFinishOrderInfoByLid(lid);
	}

	@Override
	public void updateLogisticaddress(int oid, String logisticaddress) {
		oidao.updateLogisticaddress( oid, logisticaddress);
		
	}

	@Override
	public void updateStateToSayGoodByeToThisSystem(int oid) {
		oidao.updateStateToSayGoodByeToThisSystem(oid);
		
	}

	@Override
	public void saveHaverxOrderInfoByCid(int cid, String address, String phone, String name) {
		oidao. saveHaverxOrderInfoByCid(cid, address, phone, name);
		
	}

	@Override
	public void updateUnGoInfo(int oid) {
		oidao.updateUnGoInfo(oid);
		
	}

}
