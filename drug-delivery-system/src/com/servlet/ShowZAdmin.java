package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Impl.MainDrugServiceImpl;
import com.entity.MainDrugAdmin;
import com.service.MainDrugService;


public class ShowZAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowZAdmin() {
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
		MainDrugService mdas= new MainDrugServiceImpl();
		List<MainDrugAdmin> list=mdas.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/add_zadmin.jsp").forward(request, response);
	}

}
