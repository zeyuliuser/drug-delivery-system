package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Impl.DrugServiceImpl;
import com.entity.Drug;
import com.service.DrugService;

/**
 * Servlet implementation class AddDrugServlet
 */
@WebServlet("/AddDrugServlet")
public class AddDrugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrugServlet() {
    
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
		DrugService drugService =new DrugServiceImpl();
		Drug drug= new Drug();
		request.setCharacterEncoding("utf-8");
		drug.setDname(request.getParameter("dname"));
		drug.setSize_high_cm(Double.parseDouble(request.getParameter("sizehigh")));
		drug.setSize_length_cm(Double.parseDouble(request.getParameter("sizelength")));
		drug.setSize_width_cm(Double.parseDouble(request.getParameter("sizewidth")));
		drug.setWeigth_g(Double.parseDouble(request.getParameter("weight")));
		drug.setDpic(request.getParameter("dpic"));
		drug.setDdesc(request.getParameter("ddesc"));
		drug.setPrice(Double.parseDouble(request.getParameter("price")));
		drug.setFirstclass(request.getParameter("firstclass"));
		drug.setSecondclass(request.getParameter("secondclass"));
		drug.setThirdclass(request.getParameter("thirdclass"));
		drug.setIsrx(request.getParameter("isrx"));
		drugService.save(drug);
		response.sendRedirect(request.getContextPath()+"/com/servlet/ZcompGetAllDrugServlet");
	}

}
