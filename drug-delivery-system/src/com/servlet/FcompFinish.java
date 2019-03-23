package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.OrderInfoServiceImpl;
import com.entity.OrderInfo;
import com.service.OrderInfoService;


public class FcompFinish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FcompFinish() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderInfoService oService = new OrderInfoServiceImpl();
		HttpSession session = request.getSession();
		int drugstoreid =Integer.parseInt(session.getAttribute("drugstoreid").toString());
		List<OrderInfo> orderInfos = oService.getOrderInfoByDrugStoreIdAndState(drugstoreid,2);
		request.setAttribute("list", orderInfos);
		request.getRequestDispatcher("/fcompfinish.jsp").forward(request, response);		
	}

}
