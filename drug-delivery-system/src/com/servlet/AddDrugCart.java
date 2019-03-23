package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Impl.DrugServiceImpl;
import com.entity.CustomCart;
import com.entity.Drug;
import com.service.DrugService;
import com.test.DrugStoreTest;



public class AddDrugCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrugCart() {
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
		DrugService ds= new DrugServiceImpl();
		int did =Integer.parseInt(request.getParameter("drugid"));
		int num=Integer.parseInt(request.getParameter("quantity"));
		HttpSession session=request.getSession();
		int cid=Integer.parseInt(session.getAttribute("cid").toString());
		List<CustomCart> list=ds.getCustomCartByDidAndCid(did,cid);
	
		if(list.toString()!="[]") {
			CustomCart customCart =list.get(0);
			ds.updateCustomCart(customCart.getId(),num,customCart.getNum(),customCart.getPrice());
		}else {
			Drug drug = ds.getDrugByDid(did);
			ds.createCart(did,num,cid,drug.getPrice(),drug.getDname());
		}
		response.sendRedirect(request.getContextPath()+"/com/servlet/ShowCartServlet");
		
	}

}
