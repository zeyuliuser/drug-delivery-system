package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.CustomServiceImpl;
import com.service.CustomService;



public class ChangeCustomInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCustomInfo() {
        //super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomService cs=new CustomServiceImpl();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object i=session.getAttribute("cid");
		String susername=(String)session.getAttribute("username");
		String spassword=(String)session.getAttribute("password");
		String scgender=(String)session.getAttribute("cgender");
		String srealname=(String)session.getAttribute("crname");
		String sphone=(String)session.getAttribute("phone");
		
		System.out.println(srealname);
		System.out.println(request.getParameter("realname")!="");
	
	    String username=request.getParameter("username")!= ""?request.getParameter("username"):susername;
		String password=request.getParameter("password")!=""?request.getParameter("password"):spassword;
		String cgender=request.getParameter("cgender")!=null?request.getParameter("cgender"):scgender;
		String realname=request.getParameter("realname")!=""?request.getParameter("realname"):srealname;
		String phone=request.getParameter("phone")!=""?request.getParameter("phone"):sphone;
		
		System.out.println(username);
		//System.out.println((String)session.getAttribute("cgender"));
		
		cs.updateCustomById((int)i,username,password,cgender,realname,phone);
		
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("cgender");
		session.removeAttribute("realname");
		session.removeAttribute("phone");
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("cgender", cgender);
		session.setAttribute("crname", realname);
		session.setAttribute("phone", phone);
		
		response.sendRedirect(request.getContextPath()+"/customview.jsp");
		
	}

}
