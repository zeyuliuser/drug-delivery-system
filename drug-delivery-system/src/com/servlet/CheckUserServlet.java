package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.CustomServiceImpl;
import com.service.CustomService;

/**
 * Servlet implementation class CheckUserServlet
 */
//@WebServlet("/checkUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
        //super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		CustomService customService =new CustomServiceImpl();
	    String username =request.getParameter("username");
	    boolean isExist = false;
	    try {
	    	isExist=customService.checkexist(username);
	    	 System.out.println(isExist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    response.getWriter().write("{\"isExist\":"+isExist+"}");
	    
	}

}
