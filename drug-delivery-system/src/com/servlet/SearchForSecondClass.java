package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugClassMotifyServiceImpl;
import com.entity.DrugClassMotify;
import com.google.gson.Gson;
import com.service.DrugClassMotifyService;



public class SearchForSecondClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForSecondClass() {
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
		String firstclass = request.getParameter("firstclass");
		DrugClassMotifyService dcms =new DrugClassMotifyServiceImpl();
		List<DrugClassMotify> list = dcms.searchSecondClass(firstclass);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String info = gson.toJson(list);
		out.write(info);
		
	}

}
