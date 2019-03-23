package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugServiceImpl;
import com.Impl.DrugStoreServiceImpl;
import com.service.DrugStoreService;

/**
 * Servlet implementation class AddFAdmin
 */
@WebServlet("/AddFAdmin")
public class AddFAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String sname = request.getParameter("sname");
		String spassword = request.getParameter("spassword");
		String srname =  request.getParameter("srname");
		String saddress = request.getParameter("saddress");
		String sphone = request.getParameter("sphone");
		String sgender = request.getParameter("sgender");
		DrugStoreService drugStoreService = new DrugStoreServiceImpl();
		drugStoreService.saveFAdmin(sname,spassword,srname,saddress,sphone,sgender);
		response.sendRedirect(request.getContextPath()+"/com/servlet/ShowFAdmin");
	}

}
