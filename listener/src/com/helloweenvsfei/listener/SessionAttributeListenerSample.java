package com.helloweenvsfei.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class SessionAttributeListenerSample implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(getClass());


	  public void attributeAdded(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();  // �o���ܤƪ�session
		String name=se.getName();             // �s�W�[���ݩʦW
		Object value=se.getValue();           // �s�W�[���ݩʭ�
		log.info("�s�W session �ݩ�:"+name+",�Ȭ�:"+value);
	  }
	  
	  

	  public void attributeRemoved(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();  // �o���ܤƪ�session
		String name=se.getName();             // �Y�N�R�����ݩʦW
		Object value=se.getValue();           // �Y�N�R�����ݩʭ�
		log.info("�R�� session �ݩ�:"+name+",�Ȭ�:"+value);
	  }


	  
	  public void attributeReplaced(HttpSessionBindingEvent se){
		HttpSession session=se.getSession();        // �o���ܤƪ�session
		String name=se.getName();                   // �o�ͭק諸�ݩʦW
		Object oldValue=se.getValue();              // ��Ӫ��ݩʭ�
		Object newVale=session.getAttribute(name);  // �s���ݩʭ�
		log.info("�ק� session �ݩ�:"+name+",��Ȭ�:"+oldValue+",�s��:"+newVale);
	  }
	  
	  
}
