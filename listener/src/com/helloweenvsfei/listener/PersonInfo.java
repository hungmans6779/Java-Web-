package com.helloweenvsfei.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class PersonInfo implements HttpSessionActivationListener,
		HttpSessionBindingListener, Serializable {

	
	private static final long serialVersionUID=-4780592776386225973L;
	Log log=LogFactory.getLog(getClass());
	private String name;       // �H���W�r
	private Date dateCreated;  // �إߪ����
	

	// �Q��i Session �e�Q�I�s
	public void valueBound(HttpSessionBindingEvent event) {
      HttpSession session=event.getSession();
      String name=event.getName();
      log.info(this+"�Q�j�w��session \""+session.getId()+"\"��"+name+"�ݩʤW");
      
      this.setDateCreated(new Date());
     
	}

	
	// �q Session ��������Q�I�s
	public void valueUnbound(HttpSessionBindingEvent event) {
	  HttpSession session=event.getSession();
	  String name=event.getName();
	  log.info(this+"�Q�q session \""+session.getId()+"\"��"+name+"�ݩʤW����");   
	}
	
	
	// �q�w�Ы��_��Q�I�s
	public void sessionDidActivate(HttpSessionEvent se) {
      HttpSession session=se.getSession();
      log.info(this+"�w�g���\�q�w�бq���J�CsessionId:"+session.getId());
	}

	
	// �Y�N�Q�w�ƨ�w�ЮɳQ�I�s
	public void sessionWillPassivate(HttpSessionEvent se) {
      HttpSession session=se.getSession();
      log.info(this+"�Y�N�x�s��w�СCsessionID:"+session.getId());
	}

	
	public String toString(){
	  return "PersonInfo("+name+")";	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
