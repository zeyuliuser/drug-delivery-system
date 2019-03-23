package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.LogisticAdminServiceImpl;
import com.entity.LogisticAdmin;
import com.service.LogisticAdminService;

/**
 * Servlet implementation class AddLogisticAdmin
 */
@WebServlet("/AddLogisticAdmin")
public class AddLogisticAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLogisticAdmin() {
   
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
		String lusername = request.getParameter("lusername");
		String lpassword = request.getParameter("lpassword");
		String lrname = request.getParameter("lrname");
		String laddress = request.getParameter("laddress");
		String lphone = request.getParameter("lphone");
		String lgender = request.getParameter("lgender");
		LogisticAdminService logisticAdminService = new LogisticAdminServiceImpl();
		logisticAdminService.saveAdmin(lusername,lpassword,lrname,laddress,lphone,lgender);
		response.sendRedirect(request.getContextPath()+"/com/servlet/ShowLogisticAdmin");
	}

}
