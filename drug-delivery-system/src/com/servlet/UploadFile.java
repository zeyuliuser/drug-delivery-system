package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Impl.DrugServiceImpl;
import com.entity.Drug;
import com.service.DrugService;
import com.util.ExcelUtil;



public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
       
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
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String name = "";
		DrugService dService = new DrugServiceImpl();
		ExcelUtil et = new ExcelUtil();
		 if (isMultipart) { 
	            System.out.println("1");	          
	            DiskFileItemFactory factory = new DiskFileItemFactory();	          
	            ServletFileUpload upload = new ServletFileUpload(factory);	        
	            try {
	                List<FileItem> items = upload.parseRequest(request);
	                FileItem file0 = items.get(0);	
	                System.out.println("2");
	                name = file0.getName();
	                File file=new File("C:\\Users\\LZY\\drug-delivery-system\\WebContent\\WEB-INF\\file"+"/"+file0.getName());             
	                file0.write(file);   
	                System.out.println("3");	
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
		 List<Drug> list = et.ExcelToList("C:\\Users\\LZY\\drug-delivery-system\\WebContent\\WEB-INF\\file"+"/"+name);
		 dService.saveDrugByList(list);
		 response.sendRedirect(request.getContextPath()+"/com/servlet/ZcompGetAllDrugServlet");
	    }
	

}
