package com.dxc.upload.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dxc.upload.entity.User;
import com.dxc.upload.impl.Upload;
import com.dxc.upload.impl.UserFunctions;
import com.dxc.upload.impl.UserFunctionsImpl;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/")
@MultipartConfig() 
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String filepath;
	  String appPath;
	  private static final String SAVE_DIR = "uploadFiles";
	
	  public void init( ){ // Get the file location where it would be stored.
	 // filepath = getServletContext().getInitParameter("file-upload"); 
	  filepath = getServletContext().getContextPath();
	appPath = getServletContext().getRealPath(SAVE_DIR);
	  
	  }
	 
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      response.setContentType("text/html");
	      String action = request.getServletPath();

	      
          switch (action) {
              case "/upload":
                 fileUpload(request, response);
                 break;
          
              case "/viewfiles":
                  listFiles(request, response);
                  break;
              case "/register":
                  userRegister(request, response);
                  break;
              case "/login":
                  userLogin(request, response);
                  break;
              case "/userupload":
                  userUpload(request, response);
                  break;
          }
          }
	
	
	
	 private void userUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
	String s=getServletContext().getRealPath("");
	System.out.println("realpath:"+s);
	String loginid=request.getParameter("usern");
		 System.out.println("from servlet:"+loginid);
		 Part filePart = request.getPart("file");
		 
		 UserFunctions uf=new UserFunctionsImpl();
		 
		if( uf.uploadFile(loginid,filePart,appPath,SAVE_DIR))
		{
			ArrayList<String>al=uf.listAllFiles(loginid);
			System.out.println(al);
			RequestDispatcher dispatcher = request.getRequestDispatcher("successupload.jsp"); 
			request.setAttribute("list", al); 
	         dispatcher.forward(request, response);
		}
		 
		 
		 
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		UserFunctions uf=new UserFunctionsImpl();
		String st=uf.login(id, pwd);
		if(!(st.equals("incorrect username")||st.equals("incorrect password")))
				{
		RequestDispatcher dispatcher = request.getRequestDispatcher("successlogin.jsp");
		request.setAttribute("name", st); 
         dispatcher.forward(request, response);
				}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("failurelogin.jsp");
				request.setAttribute("name", st); 
		         dispatcher.forward(request, response);
		}
					
		
	}

	private void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String loginid=request.getParameter("loginid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String addr=request.getParameter("address");
		String phno=request.getParameter("phno");
		User u=new User(name,loginid,pwd,email,addr,phno);
		UserFunctions uf=new UserFunctionsImpl();
		String username=uf.register(u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("successregi.jsp");
		request.setAttribute("name", username); 
         dispatcher.forward(request, response);
	}



	Upload up=new Upload();
	         private void listFiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList files=up.listAllFiles(appPath);
	
		
	         RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
			request.setAttribute("listfiles", files); 
	         dispatcher.forward(request, response);
	    	  
	        	 
	        	 
	}
			private void fileUpload(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	        	try {
					/*
					 * String appPath = request.getServletContext().getRealPath("");
					 * System.out.println(appPath); String savePath = appPath + File.separator +
					 * SAVE_DIR; System.out.println(savePath);
					 */
	        		
	        		//String appPath = getServletContext().getRealPath(SAVE_DIR);
	        		System.out.println(appPath);
	        		 String savePath = appPath + "//" +SAVE_DIR; 
	        		 System.out.println(savePath);
						Collection<Part>cp= request.getParts();
	        	    String fileName = up.fileUpload(cp,appPath);
	        	    System.out.println(fileName);
	    	        
	    	         request.setAttribute("message", "The file "+fileName+" has been uploaded successfully!");
	    	         RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
	    	         dispatcher.forward(request, response);
	}catch(Exception ex) {
        System.out.println(ex);
     }
	         }
			
	       
				
				  
	      
	 
	}

