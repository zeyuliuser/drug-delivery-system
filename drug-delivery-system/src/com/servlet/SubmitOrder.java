package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Impl.OrderInfoServiceImpl;

import com.service.OrderInfoService;

public class SubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OrderInfoService ois = new OrderInfoServiceImpl();
		HttpSession session = request.getSession();
		int cid = Integer.parseInt(session.getAttribute("cid").toString());
		System.out.println("hello");
	/*	
		String address = request.getParameter("address");
		System.out.println(address);
		String phone = request.getParameter("phone");*/
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 if (isMultipart) { 
	            System.out.println("1");	 
	            String address="";
	            String phone = "";
	            DiskFileItemFactory factory = new DiskFileItemFactory();	          
	            ServletFileUpload upload = new ServletFileUpload(factory);	        
	            try {	        
	                List<FileItem> items = upload.parseRequest(request);
	                FileItem file2 = items.get(2);
	                FileItem file0 = items.get(0);	
	                address = file0.getString("utf-8");
	                System.out.println(address);
	                FileItem file1 = items.get(1);
	                phone = file1.getString("utf-8");
	                System.out.println(phone);
	                if(file2.getSize()==0) {	               
	                ois.saveOrderInfoByCid(cid, address, phone);
	                }else {
	                	File file=new File("C:\\Users\\LZY\\drug-delivery-system\\WebContent\\web_pic"+"/"+file2.getName());             
	 	                file2.write(file);  
	 	               ois.saveHaverxOrderInfoByCid(cid, address, phone,file2.getName());
					}	                
	                System.out.println(file2.getSize()==0);
	            } catch (FileUploadException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }else {
	        	System.out.println("0");
	        }
		
		response.sendRedirect(request.getContextPath() + "/com/servlet/ShowCustomOrder");

	}

}
