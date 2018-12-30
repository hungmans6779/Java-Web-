package com.helloweenvsfei.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class ListenerTest implements HttpSessionListener,
		ServletContextListener, ServletRequestListener {

	Log log = LogFactory.getLog(getClass());

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("�s�إߤ@��session,ID ��" + session.getId());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("�P���@��session,ID ��" + session.getId());
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("�Y�N�Ұ� " + servletContext.getContextPath());
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("�Y�N���� " + servletContext.getContextPath());
	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		String uri = request.getRequestURI();
		uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());
		request.setAttribute("dateCreated", System.currentTimeMillis());
		log.info("IP" + request.getRemoteAddr() + " �ШD " + uri);
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		long time = System.currentTimeMillis()- (Long) request.getAttribute("dateCreated");
		log.info(request.getRemoteAddr() + " �ШD�B�z����,�ή�" + time + "����.");
	}

}
