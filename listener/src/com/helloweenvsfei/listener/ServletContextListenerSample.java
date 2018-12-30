package com.helloweenvsfei.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class ServletContextListenerSample implements ServletContextListener{
	Log log = LogFactory.getLog(getClass());
	

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("�Y�N�Ұ� " + servletContext.getContextPath());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("�Y�N���� " + servletContext.getContextPath());
	}
	
	
}
