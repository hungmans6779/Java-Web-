package com.helloweenvsfei.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;



public class LoginSessionListener implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(this.getClass());
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	
	// �W�[ Session �ݩʮɳQ�I�s
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();

		// �n�J
		if (name.equals("personInfo")) {
			PersonInfo personInfo = (PersonInfo) event.getValue();
			if (map.get(personInfo.getAccount()) != null) {
				// map �����O���A����ӱb���b��L�����W�n�J�L�A�N�H�e���n�J����
				HttpSession session = map.get(personInfo.getAccount());
				PersonInfo oldPersonInfo = (PersonInfo) session.getAttribute("personInfo");
				log.info("�b��" + oldPersonInfo.getAccount() + "�b"+ oldPersonInfo.getIp() + "�w�g�n�J�A�ӵn�J�N�Q���U�u�C");
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "�z���b���w�g�b��L�����W�n�J�A�z�Q���U�u�C");
			}

			// �Nsession�H�ϥΪ̦W�٬����ޡA��Jmap��
			map.put(personInfo.getAccount(), event.getSession());
			log.info("�b��" + personInfo.getAccount() + "�b" + personInfo.getIp()+ "�n�J�C");
		}
	}

	
	
	
	// �R���ݩʫe�Q�I�s
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		// ���P
		if (name.equals("personInfo")) {
			// �N��session�qmap������
			PersonInfo personInfo = (PersonInfo) event.getValue();
			map.remove(personInfo.getAccount());
			log.info("�b��" + personInfo.getAccount() + "���P�C");
		}
	}

	
	
	// �ק��ݩʮɳQ�I�s
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		// �S�����P�����p�U�A�Υt�@�ӱb���n�J
		if (name.equals("personInfo")) {
			// �����ª����n�J��T
			PersonInfo oldPersonInfo = (PersonInfo) event.getValue();
			map.remove(oldPersonInfo.getAccount());

			// �s���n�J��T
			PersonInfo personInfo = (PersonInfo) event.getSession().getAttribute("personInfo");

			// �]�n�ˬd�s�n�J���b���O�_�b�O�������W�n�J�L
			if (map.get(personInfo.getAccount()) != null) {
				// map �����O���A����ӱb���b��L�����W�n�J�L�A�N�H�e���n�J����
				HttpSession session = map.get(personInfo.getAccount());
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "�z���b���w�g�b��L�����W�n�J�A�z�Q���U�u�C");
			}
			map.put("personInfo", event.getSession());
		}
	}

	
	
	
}
