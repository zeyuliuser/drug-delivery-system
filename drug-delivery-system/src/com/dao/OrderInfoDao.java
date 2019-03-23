package com.dao;

import java.util.List;

import com.entity.OrderInfo;

public interface OrderInfoDao {

	void saveOrderInfoByCid(int cid, String address, String phone);

	List<OrderInfo> getOrderInfoByCidAndState(int cid, int i);

	void updateStateToCancel(int oid);

	List<OrderInfo> getUnfinishOrder();

	List<OrderInfo> getUnAcceptOrder();

	List<OrderInfo> getAllFinishDrugToZcomp();

	OrderInfo getOrderByOid(int oid);

	List<OrderInfo> getOrderInfoByDrugStoreIdAndState(int drugstoreid, int i);

	void updateOrderInfoByStaffid(int staffid, int oid, int lid);

	List<OrderInfo> getOrderInfoByLidAndState(int lid, int i);

	List<OrderInfo> searchUnDispatcherCarOrderByLid(int lid);

	void updateOrderWithCarid(int oid, String carid);

	List<OrderInfo> getUnFinishOrderInfoByLid(int lid);

	void updateLogisticaddress(int oid, String logisticaddress);

	void updateStateToSayGoodByeToThisSystem(int oid);

	void saveHaverxOrderInfoByCid(int cid, String address, String phone, String name);

	void updateUnGoInfo(int oid);

}
