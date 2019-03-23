package com.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.CustomServiceImpl;
import com.Impl.DrugStoreServiceImpl;
import com.Impl.LogisticAdminServiceImpl;
import com.Impl.MainDrugServiceImpl;
import com.entity.Custom;
import com.entity.DrugStore;
import com.entity.LogisticAdmin;
import com.entity.MainDrugAdmin;
import com.service.CustomService;
import com.service.DrugStoreService;
import com.service.LogisticAdminService;
import com.service.MainDrugService;


public class UserConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserConfirmServlet() {
		//super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String idContext = request.getParameter("choose");
		if (idContext.equals("custom")) {
			CustomService cs= new CustomServiceImpl();			
			Custom custom = cs.searchByUsername(username);
			if(custom!=null&&custom.getPassword().equals(password)) {
				//****************************************************
				HttpSession session = request.getSession();
				session.setAttribute("cid",custom.getCid());
				session.setAttribute("username", custom.getUsername());
				session.setAttribute("password", custom.getPassword());
				session.setAttribute("cgender", custom.getCgender());
				session.setAttribute("crname", custom.getRealname());
				session.setAttribute("phone", custom.getphone());
				//*****************************************************
			response.sendRedirect(request.getContextPath()+"/customview.jsp");				
			}
			else {
				response.sendRedirect(request.getContextPath()+"/wrongpassword.jsp");
			}


		}
		else if (idContext.equals("zcomp")) {
			MainDrugService md=new MainDrugServiceImpl();
			MainDrugAdmin maindrugadmin = md.searchByAdmin(username);
			if(maindrugadmin!=null&&maindrugadmin.getMpassword().equals(password)) {
				//****************************************************
				HttpSession session = request.getSession();
				session.setAttribute("mid",maindrugadmin.getMid());
				session.setAttribute("madmin", maindrugadmin.getMadmin());
				session.setAttribute("mpassword", maindrugadmin.getMpassword());
				session.setAttribute("mrname", maindrugadmin.getMrname());
			
			    response.sendRedirect(request.getContextPath()+"/zcomp.jsp");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/wrongpassword.jsp");
			}
		}
		else if (idContext.equals("fcomp")) {
			
			DrugStoreService dss =new DrugStoreServiceImpl();
			DrugStore drugStore=dss.searchByAdmin(username);
			if(drugStore!=null&&drugStore.getSpassword().equals(password)) {
				//****************************************************
				HttpSession session = request.getSession();
				session.setAttribute("staffid",drugStore.getStaffid());
				session.setAttribute("sname", drugStore.getSname());
				session.setAttribute("srname", drugStore.getSrname());
				session.setAttribute("spassword", drugStore.getSpassword());
				session.setAttribute("drugstoreid", drugStore.getDrugstoreid());
			
			    response.sendRedirect(request.getContextPath()+"/fcomp.jsp");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/wrongpassword.jsp");
			}
			
		}
		else if(idContext.equals("logistic")) {
			LogisticAdminService las =new LogisticAdminServiceImpl();
			LogisticAdmin lAdmin=las.searchByAdmin(username);
			if(lAdmin!=null&&lAdmin.getLpassword().equals(password)) {
				//****************************************************
				HttpSession session = request.getSession();
				session.setAttribute("lid",lAdmin.getLid());
				response.sendRedirect(request.getContextPath()+"/logistic.jsp");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/wrongpassword.jsp");
			}
			
		}

	}
}