package com.helloweenvsfei.util;

import javax.servlet.ServletRequestEvent;

import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequestListener implements ServletRequestListener {

	// �P��request �ɩI�s
	public void requestDestroyed(ServletRequestEvent event) {
	}

	
	// �إ�request �ɩI�s
	public void requestInitialized(ServletRequestEvent event) {

		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		HttpSession session = request.getSession(true);

		// �O��IP�a�}
		session.setAttribute("ip", request.getRemoteAddr());

		// �O���s�����ơA�u�O���s�� .html, .do, .jsp, .action ���֭p����
		String uri = request.getRequestURI();
		String [] suffix = {".html", ".do", ".jsp", ".action" };
		for(int i=0; i<suffix.length;i++){
		  if(uri.endsWith(suffix[i])) {
			break;
		  }
		  if(i == suffix.length-1){
			return;
		  }	
		}

		Integer activeTimes = (Integer) session.getAttribute("activeTimes");
		if(activeTimes == null) {
		  activeTimes = 0;
		}
		session.setAttribute("activeTimes", activeTimes + 1);
	}
	
	
}
