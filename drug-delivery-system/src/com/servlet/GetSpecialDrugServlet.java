package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugServiceImpl;
import com.entity.Drug;
import com.service.DrugService;

/**
 * Servlet implementation class GetSpecialDrugServlet
 */
@WebServlet("/GetSpecialDrugServlet")
public class GetSpecialDrugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSpecialDrugServlet() {
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
		DrugService ds =new DrugServiceImpl();
		request.setCharacterEncoding("utf-8");
		String s =new String(request.getParameter("drug_name"));
		List<Drug> list = ds.getSpecialAllDrug(s);
		request.setAttribute("druglist", list);
		request.getRequestDispatcher("/special_drug_table.jsp").forward(request, response);
		
	}

}
