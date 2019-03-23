package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.MainDrugServiceImpl;
import com.service.MainDrugService;


public class AddZAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddZAdmin() {
        super();
        // TODO Auto-generated constructor stub
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
		MainDrugService mainDrugService=new MainDrugServiceImpl();
		request.setCharacterEncoding("utf-8");
		String madmin = request.getParameter("madmin");
		String mpassword = request.getParameter("mpassword");
		String mrname = request.getParameter("mrname");
		System.out.println(madmin+"/"+mpassword+"/"+mrname);
		mainDrugService.save(madmin,mpassword,mrname);
		response.sendRedirect(request.getContextPath()+"/com/servlet/ShowZAdmin");
		
	}

}
