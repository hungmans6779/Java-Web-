package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadSafetyServlet extends HttpServlet {

	private String name;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
		  Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		response.getWriter().println("�z�n, " + name + ". �z�ϥΤF GET �覡�ǰe���");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().println("�z�n, " + name + ". �z�ϥΤF POST �覡�ǰe���");
	}
}
