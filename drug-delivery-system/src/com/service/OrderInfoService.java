package com.service;

import java.util.List;

import com.entity.OrderInfo;

public interface OrderInfoService {

   public void saveOrderInfoByCid(int cid, String address, String phone);

public List<OrderInfo> getOrderInfoByCidAndState(int cid, int i);

public void updateStateToCancel(int oid);

public List<OrderInfo> getUnfinishOrder();

public List<OrderInfo> getUnAcceptOrder();

public List<OrderInfo> getAllFinishDrugToZcomp();

public OrderInfo getOrderByOid(int oid);

public List<OrderInfo> getOrderInfoByDrugStoreIdAndState(int drugstoreid, int i);

public void updateOrderInfoByStaffid(int staffid, int oid, int lid);

public List<OrderInfo> getOrderInfoByLidAndState(int lid, int i);

public List<OrderInfo> searchUnDispatcherCarOrderByLid(int lid);

public void updateOrderWithCarid(int oid, String carid);

public List<OrderInfo> getUnFinishOrderInfoByLid(int lid);

public void updateLogisticaddress(int oid, String logisticaddress);

public void updateStateToSayGoodByeToThisSystem(int oid);

public void saveHaverxOrderInfoByCid(int cid, String address, String phone, String name);

public void updateUnGoInfo(int oid);

}
