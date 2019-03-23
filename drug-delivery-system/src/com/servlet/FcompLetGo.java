package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.OrderInfoServiceImpl;
import com.service.OrderInfoService;


public class FcompLetGo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FcompLetGo() {
       
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
		HttpSession session = request.getSession();
		int staffid = Integer.parseInt(session.getAttribute("staffid").toString());
		int oid = Integer.parseInt(request.getParameter("oid"));
		int lid = Integer.parseInt(request.getParameter("lid"));
		oService.updateOrderInfoByStaffid(staffid,oid,lid);
		response.sendRedirect(request.getContextPath()+"/com/servlet/FcompUnFinish");
	}

}
