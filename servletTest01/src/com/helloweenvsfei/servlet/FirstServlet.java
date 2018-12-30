package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletConfig;

public class FirstServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public FirstServlet() {
		super();
	}

	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	
	
	String message=null;
    String encoding=null;
	
	public void init(ServletConfig config) throws ServletException {
	   super.init(config);
	   message=getInitParameter("message");
	   encoding=getInitParameter("encoding");
	}

	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	   this.log("���� doGet ��k...");
	   this.execute(request, response);
	}

	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  this.log("���� doPost ��k...");
	  this.execute(request, response);
	}

	
	public long getLastModified(HttpServletRequest request){
	  this.log("���� getLastModified ��k...");
	  return -1;
	}
	
	
	private void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	 
	  response.setCharacterEncoding("UTF-8");
	  request.setCharacterEncoding("UTF-8");
	  
	  String requestURI=request.getRequestURI();
	  String method=request.getMethod();
	  String param=request.getParameter("param");
	  

   
	  response.setContentType("text/html");
	  PrintWriter out=response.getWriter();
	  
	  out.println("<html>");
	  out.println("  <head><title>A Servelt</title></head>");
	  out.println("  <body>");
	  out.println("    init �Ѽ� message = "+message+" ,encoding = "+encoding+"<br>");
	  out.println("    �H  "+method+" �覡�s���ӭ����C���쪺 param �ѼƬ��G"+param+"<br>");
	 
	  out.println("    <form action='"+requestURI+"' method='get' > ");
	  out.println("       <input type='text' name='param' value='param string' />");
	  out.println("       <input type='submit' value='�H GET �覡�d�߭��� "+requestURI+"' />");
	  out.println("    </form>");
	  
	  out.println("    <form action='"+requestURI+"' method='post' > ");
	  out.println("       <input type='text' name='param' value='param string' />");
	  out.println("       <input type='submit' value='�H POST �覡�d�߭��� "+requestURI+"' />");
	  out.println("    </form>");
	  
	  out.println("    <script>document.write('�������̫��s�ɶ��G'+document.lastModified);</script>");
	  out.println("  </body>");
	  out.println("</html>");
		
	  out.flush();
	  out.close();
	  
	}
	


	
	

	
}
