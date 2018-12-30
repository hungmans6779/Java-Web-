package com.webservice.auth;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

/*
 *  �iSOAP Header ���i�樭�����ҡj
 *   
 *  �p�G�bSOAP Header �����������Ҫ��覡����S��A�O�ۤv�q���@�ؤ覡�A�i�H�z�LHandler �ӳB�z�A
 *  �ƹ�W Handler ���ȶȯ�B�z SOAP Header �A���]�i�H�B�z SOAP Body�C 
 *  
 *  ����h�ݭn�b�Τ�ݩM���A���ݼW�[�o�e�{�Ҹ�T�M�B�z�{�Ҹ�T��Handler�C
 *  
 *  �Τ�ݵo�eSOAP �T���ɡA�z�L�W�[ outHandler �� SOAP ���Y��T���W�[��������T�F
 *  ���A���ݭn�b�I�s�A�ȫe�z�L�W�[ inHandler �ӭt�d�{�Τ�ݪ��ШD�A�ѻ{�ҬO�_�z�L�ӨM�w�O�_���ѪA�ȡC
 *  �L�׬O���A���ݪ� Handler �O�Τ�ݪ�Handler �A���n�~�� org.codehaus.xfire.handler.AbstractHandler ���O�A��{�䤤�� invoke ��k�C
 *  
 *  
 *  ���d�Ҭ��Τ�ݡG
 *  (1) �b�Τ�ݼW�[��a������ ClientAuthenticationHandler ���O�A�����O�t�d�b soap �T�����Y���W�[������T�C
 *  (2) �N Handler �����Τ�ݪ��{���X���C
 *  
 */
public class ClientAuthenticationHandler extends AbstractHandler {

  // soap�T�����R�W�Ŷ�
  public final Namespace ns = Namespace.getNamespace("http://xfire.webservice.com");
  
  private String username = null;   // �ϥΪ̦W��
  private String password = null;   // �K�X
  
  
  // ���a���Ѽƪ��غc�l
  public ClientAuthenticationHandler(){}
  
  // �a���Ѽƪ��غc�l
  public ClientAuthenticationHandler(String username,String password){
	 this.username = username;
	 this.password = password;
  }

  
  
  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }


  
  
  
  
  
   
  public void invoke(MessageContext context) throws Exception {

	// �إ� header �`�I
	Element el = new Element("header",ns);
	
	// �W�[�� soap ��
	context.getOutMessage().setHeader(el);

	Element auth = new Element("AuthenticationToken",ns);
	
	
	
	
	// �W�[�{�Ҩ�����T
	Element usernameElement = new Element("username",ns);
	usernameElement.addContent(username);
	auth.addContent(usernameElement);
	
	Element passwordElement = new Element("password",ns);
	passwordElement.addContent(password);
	auth.addContent(passwordElement);
	
	
	// �N�{�Ҩ����W�[�� header ��  
	el.addContent(auth);

  } // end invoke
 
  
  
  
  
  
  
	 
}
