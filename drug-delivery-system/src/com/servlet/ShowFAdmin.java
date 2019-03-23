package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugStoreServiceImpl;
import com.entity.DrugStore;
import com.service.DrugStoreService;

/**
 * Servlet implementation class ShowFAdmin
 */
@WebServlet("/ShowFAdmin")
public class ShowFAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFAdmin() {
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
		
		DrugStoreService drugStoreService= new DrugStoreServiceImpl();
		List<DrugStore> list = drugStoreService.getAllDurgStore();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/fcompshowadmin.jsp").forward(request, response);
	}

}
