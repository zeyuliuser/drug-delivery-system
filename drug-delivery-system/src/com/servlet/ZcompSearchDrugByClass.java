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


public class ZcompSearchDrugByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZcompSearchDrugByClass() {
     
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
		DrugService dService= new DrugServiceImpl();
		request.setCharacterEncoding("utf-8");
		String firstclass = request.getParameter("firstclass");
		String note = request.getParameter("secondclass");
		String[] array = note.split("/");
		String secondclass = array[0];
		String thirdclass = array[1];
		List<Drug> list = dService.findDrugByClass(firstclass,secondclass,thirdclass);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/company_drug_table.jsp").forward(request, response);
	}

}
