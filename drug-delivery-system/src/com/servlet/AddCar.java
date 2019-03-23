package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.LogisticAdminServiceImpl;
import com.service.LogisticAdminService;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {

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
		LogisticAdminService las= new LogisticAdminServiceImpl();
		request.setCharacterEncoding("utf-8");
		String carid = request.getParameter("carid");
		String driver = request.getParameter("driver");
		int carstate =Integer.parseInt(request.getParameter("carstate"));
		String caraddress = request.getParameter("caraddress");
		las.saveCar(carid,driver,carstate,caraddress);
		response.sendRedirect(request.getContextPath()+"/com/servlet/CarManager");
		
		
	}

}
