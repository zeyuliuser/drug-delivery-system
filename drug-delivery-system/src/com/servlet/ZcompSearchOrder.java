package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.OrderInfoServiceImpl;
import com.entity.OrderInfo;
import com.service.OrderInfoService;


public class ZcompSearchOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZcompSearchOrder() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderInfoService oService = new OrderInfoServiceImpl();
		int oid = Integer.parseInt(request.getParameter("oid"));
		OrderInfo orderInfo = new OrderInfo();
		orderInfo = oService.getOrderByOid(oid);
		request.setAttribute("oid", oid);
		request.setAttribute("odesc", orderInfo.getOdesc());
		request.setAttribute("address", orderInfo.getAddress());
		request.setAttribute("saddress", orderInfo.getSaddress());
		request.setAttribute("allamount", orderInfo.getAllamount());
		request.setAttribute("logisticaddress", orderInfo.getLogisticaddress());
		request.setAttribute("state", orderInfo.getState());
		request.getRequestDispatcher("/zcompsearchorder.jsp").forward(request, response);
	}

}
