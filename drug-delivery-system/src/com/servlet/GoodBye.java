package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.OrderInfoServiceImpl;
import com.entity.OrderInfo;
import com.service.OrderInfoService;

public class GoodBye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodBye() {
       
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
		request.setCharacterEncoding("utf-8");
		OrderInfoService oService =new OrderInfoServiceImpl();
		int oid = Integer.parseInt(request.getParameter("oid"));
		oService.updateStateToSayGoodByeToThisSystem(oid);
		response.sendRedirect(request.getContextPath()+"/com/servlet/ShowCustomFinish");
	}

}
