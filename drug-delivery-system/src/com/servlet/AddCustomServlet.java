package com.servlet;

import java.io.IOException;
/*import java.lang.reflect.InvocationTargetException;*/

import javax.servlet.ServletException;
/*import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.beanutils.BeanUtils;

import com.Impl.CustomServiceImpl;
import com.entity.Custom;
import com.service.CustomService;

/*@WebServlet("/AddCustomServlet")*/
public class AddCustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private CustomService customService =new CustomServiceImpl();
    public AddCustomServlet() {
        //super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		Custom s=new Custom();
		/*try {
			BeanUtils.populate(s, request.getParameterMap());
			
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}*/
		request.setCharacterEncoding("utf-8");
		s.setUsername(request.getParameter("username"));
		s.setPassword(request.getParameter("password"));
		s.setRealname(request.getParameter("realname"));
		s.setCgender(request.getParameter("cgender"));
		s.setphone(request.getParameter("phone"));
		customService.save(s);
    	response.sendRedirect(request.getContextPath()+"/login.jsp");
		
		
		
	}

}
