package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.DrugServiceImpl;
import com.service.DrugService;


public class CheckUserIsrx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserIsrx() {
        
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
		DrugService ds = new DrugServiceImpl();
		HttpSession session = request.getSession();
		int cid = Integer.parseInt(session.getAttribute("cid").toString());
		boolean isRxInCart  = false;
	    try {
	    	isRxInCart=ds.searchCartIfIsrxByCid(cid);
	    	 System.out.println(isRxInCart);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    response.getWriter().write("{\"isRxInCart\":"+isRxInCart+"}");
		
		
	}

}
