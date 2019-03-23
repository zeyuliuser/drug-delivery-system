package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.OrderInfoServiceImpl;
import com.entity.OrderInfo;
import com.service.OrderInfoService;


public class GetAllUnFinishOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllUnFinishOrder() {
       
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
		OrderInfoService oInfoService = new OrderInfoServiceImpl();
		List<OrderInfo> list = oInfoService.getUnfinishOrder();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/zcomp_show_unfinish.jsp").forward(request, response);
		
	}

}
