package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.LogisticAdminServiceImpl;
import com.service.LogisticAdminService;


public class RepairCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairCar() {
       
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
		LogisticAdminService adminService = new LogisticAdminServiceImpl();
		
		request.setCharacterEncoding("utf-8");
		String carid = request.getParameter("carid");
		adminService.repairCarById(carid);
		response.sendRedirect(request.getContextPath()+"/com/servlet/CarManager");
		
	}

}
