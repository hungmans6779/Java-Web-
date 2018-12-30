package com.helloweenvsfei.struts2.action;

import java.io.File;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/*
 * Struts2.x �� Action �� ���@�w�n��{ Action �����A���� POJO ���i�H�ΰ� Action �A�u�n�o�� Action �㦳 public String execute() ��k�C

 * �p�G Struts2 �o�{ Action ���O�S����{ Action �����A�|�z�L�Ϯg�өI�s execute() ��k�C
 */




/*
 *  �����O����{���󤶭��A���~�ӥ������O
 *  ����{ Action �������n�B�O���P Struts2 �o�ͽ��X�A�{���X���̩ۨ� Struts2 �����O�禡�w
 *  Struts2 �٥i�H���� Action ����L��k�A�u�n�o�Ǥ�k�S���ѼơA�öǦ^ String �����C�o�Ǥ�k�]�i�H�� throws �ŧi�A�]�i�H�S���C
 *  Struts2 �|�b����ɮھڤ�k���S�x�P�_�O�_�i�����k(�ѼơB�Ǧ^)�A�óz�L�Ϯg����C
 *  login() �� logout() �ä��O�w�]�i�����k�C�i�N��]�w�� struts.xml ���A�Ϊ̳z�L�S�w�� URL
 *  (�Ҧp�G loginPerson3!login.action �B loginPerson3!logout.action ��)��������o�ǫD�w�w��k�C
 */
public class LoginAction3 {

	private String account;   // �b��
	private String password;  // �K�X

	
	
	  
	// �D��k
	// Struts2.x �� Action �� ���@�w�n��{ Action �����A���� POJO ���i�H�ΰ� Action �A�u�n�o�� Action �㦳 public String execute() ��k�C
	// �p�G Struts2 �o�{ Action ���O�S����{ Action �����A�|�z�L�Ϯg�өI�s execute() ��k�C
	public String execute(){
	  System.out.println(LoginAction3.class.getName()+",execute() ����F");
		 
	  // �z�L ServletActionContext ���o request,response ����
	  HttpServletRequest request = ServletActionContext.getRequest();

	  // �N�b����� session ��
	  HttpSession session = request.getSession(true);
	  session.setAttribute("account",account);
	  
	  System.out.println("**************************************************");
	  System.out.println("execute()");
	  System.out.println("01.account         = "+account);
	  System.out.println("02.password        = "+password);
	  System.out.println("03.account         => request.getParameter('account')  = "+request.getParameter("account"));
	  System.out.println("04.password-1      => request.getParameter('password') = "+request.getParameter("password"));
	  System.out.println("05.session account => session.getAttribute('account')  = "+session.getAttribute("account"));
	  System.out.println("**************************************************");
				
	  if("kevin".equals(account) && "1234".equals(password)){
		return "success";   // �Ǧ^���\����
	  }
	  
	  return "login";       // �Ǧ^�n�J����
	} // end execute() 
	

	
	
	
	
	
	// �n�J��k
	public String login() throws Exception{
	  System.out.println(LoginAction3.class.getName()+",login() ����F");
	  
	  // �z�L ServletActionContext ���o request,response ����
	  HttpServletRequest request = ServletActionContext.getRequest();
	  HttpServletResponse response = ServletActionContext.getResponse();

	  // �N�b����� session ��
	  HttpSession session = request.getSession(true);
	  session.setAttribute("account",account);
	  
	  // ��o Web ���ήڥؿ��U�� /upload �ɮק�
	  ServletContext context = ServletActionContext.getServletContext();
	  File uploadFile = new File(context.getRealPath("upload"));
	  
	  System.out.println("**************************************************");
	  System.out.println("login() ");
	  System.out.println("01.account    => request.getParameter('account')  = "+request.getParameter("account"));
	  System.out.println("02.password-1 => request.getParameter('password') = "+request.getParameter("password"));
	  System.out.println("**************************************************");
				
	  
	  return execute(); // �Ǧ^�D��k	
	} // end     DROP TABLE itrocko_person;
	
	
	
	
	
	
	// ���P��k
	public String logout(){
      System.out.println(LoginAction3.class.getName()+",logout() ����F");
	  return "logout"; // �Ǧ^�n�X����
	} // end logout
	
	
	
	
	
	
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
