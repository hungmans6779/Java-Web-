package com.helloweenvsfei.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/*
 *  Struts2.x ���C�� Action ��ҷ|�Q���ШϥΡC�� Struts 2 ���C�� Action ���|���h�ӹ�ҡA�B�z�@���ШD���ͤ@�ӹ�ҡA
 *  �o�ǹ�ҩ����W�ߡA�B�z�����Y�P���C
 *  �ҥH Struts 2 �O������w�����C�ѩ� Action ���S����L�S��귽�A�ϥΧ�����K�Q�����߱�A�Ӥ��|�y�����O�C
 *  
 *  ActionSupport ����{�F��L����k�A�Ҧp������ҵ��A�~�� ActionSupport ���n�B�O�i�H�����ϥθ�����ҵ�  Struts2 ��X��k�C
 */
public class LoginAction extends ActionSupport {

	private String account;     // �b��
	private String password;    // �K�X

	
    // �D��k
	public String execute(){
	
	  System.out.println("********************************");
	  System.out.println(LoginAction.class.getName());
	  System.out.println("01.account  = "+account);
	  System.out.println("02.password = "+password);
	  System.out.println("********************************");
		
	  if("kevin".equals(account) && "1234".equals(password)){
		return SUCCESS;      // �Ǧ^���\����
		// return "success";
	  }
	  
	  // return LOGIN;      // �Ǧ^�n�J����
	  return "login";
	  
	} // end execute
	
	
	
	
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
