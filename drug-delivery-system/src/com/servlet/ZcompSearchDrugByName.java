package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugServiceImpl;
import com.entity.Drug;
import com.service.DrugService;


public class ZcompSearchDrugByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZcompSearchDrugByName() {
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
		request.setCharacterEncoding("utf-8");
		DrugService dService = new DrugServiceImpl();
		String dname = request.getParameter("dname");
		System.out.println(dname);
		List<Drug> list = dService.SearchDrugByName(dname);
		System.out.println(list.get(0).getDdesc());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/company_specialdrug_table.jsp").forward(request, response);
	}

}
