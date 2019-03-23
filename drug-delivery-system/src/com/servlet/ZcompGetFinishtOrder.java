package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugServiceImpl;
import com.Impl.OrderInfoServiceImpl;
import com.entity.Drug;
import com.entity.OrderInfo;
import com.service.DrugService;
import com.service.OrderInfoService;


public class ZcompGetFinishtOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZcompGetFinishtOrder() {
       
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

		
		OrderInfoService oInfoService =new OrderInfoServiceImpl();
		List<OrderInfo> list = oInfoService.getAllFinishDrugToZcomp();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/zcomp_finish.jsp").forward(request, response);
		

	}

}
