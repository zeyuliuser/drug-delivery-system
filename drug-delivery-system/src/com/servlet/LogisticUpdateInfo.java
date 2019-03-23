package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.OrderInfoServiceImpl;
import com.service.OrderInfoService;

public class LogisticUpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogisticUpdateInfo() {
     
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
		request.setCharacterEncoding("utf-8");
		int oid =Integer.parseInt(request.getParameter("oid"));
		String logisticaddress = request.getParameter("logisticaddress");
		oService.updateLogisticaddress(oid,logisticaddress);
		response.sendRedirect(request.getContextPath()+"/com/servlet/LogisticFinishing");
		
	}

}
