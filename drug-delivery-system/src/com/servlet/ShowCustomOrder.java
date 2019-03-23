package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.DrugServiceImpl;
import com.Impl.OrderInfoServiceImpl;
import com.entity.CustomCart;
import com.entity.OrderInfo;
import com.service.DrugService;
import com.service.OrderInfoService;

public class ShowCustomOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomOrder() {
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
		OrderInfoService oService= new OrderInfoServiceImpl();
		HttpSession session=request.getSession();
		int cid = Integer.parseInt(session.getAttribute("cid").toString());
		List<OrderInfo> list = oService.getOrderInfoByCidAndState(cid,0);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/c_wait_order.jsp").forward(request, response);
	}

}
