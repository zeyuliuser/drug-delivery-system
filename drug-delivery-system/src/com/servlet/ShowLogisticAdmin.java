package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.LogisticAdminServiceImpl;
import com.entity.LogisticAdmin;
import com.service.LogisticAdminService;

/**
 * Servlet implementation class ShowLogisticAdmin
 */
@WebServlet("/ShowLogisticAdmin")
public class ShowLogisticAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLogisticAdmin() {
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
		LogisticAdminService logisticAdminService= new LogisticAdminServiceImpl();
		List<LogisticAdmin> list = logisticAdminService.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/showlogisticadmin.jsp").forward(request, response);
	}

}
