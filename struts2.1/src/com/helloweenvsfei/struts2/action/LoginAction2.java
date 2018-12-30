package com.helloweenvsfei.struts2.action;


/*
 * Struts2.x �� Action �� ���@�w�n��{ Action �����A����POJO ���i�H�ΰ�Action �A�u�n�o�� Action �㦳 public String execute() ��k�C
 * �p�G Struts2 �o�{ Action ���O�S����{ Action �����A�|�z�L�Ϯg�өI�s execute() ��k�C
 */


/*
 *  �����O����{���󤶭��A���~�ӥ������O
 *  ����{ Action �������n�B�O���P Struts2 �o�ͽ��X�A�{���X���̩ۨ� Struts2 �����O�禡�w
 *  Struts2 �٥i�H���� Action ����L��k�A�u�n�o�Ǥ�k�S���ѼơA�öǦ^ String �����C�o�Ǥ�k�]�i�H�� throws �ŧi�A�]�i�H�S���C
 *  Struts2 �|�b����ɮھڤ�k���S�x�P�_�O�_�i�����k(�ѼơB�Ǧ^)�A�óz�L�Ϯg����C
 */
public class LoginAction2 {

	private String account;   // �b��
	private String password;  // �K�X
	
	
	// �D��k
	// Struts2.x �� Action �� ���@�w�n��{ Action �����A���� POJO ���i�H�ΰ� Action �A�u�n�o�� Action �㦳 public String execute() ��k�C
	// �p�G Struts2 �o�{ Action ���O�S����{ Action �����A�|�z�L�Ϯg�өI�s execute() ��k�C
	public String execute(){
	  System.out.println(LoginAction2.class.getName()+",execute() ����F...");
		 
	  System.out.println("********************************");
	  System.out.println(LoginAction2.class.getName());
	  System.out.println("01.account  = "+account);
	  System.out.println("02.password = "+password);
	  System.out.println("********************************");
			
	  if("kevin".equals(account) && "1234".equals(password)){
		return "success";   // �Ǧ^���\����
	  }
	  
	  return "login";       // �Ǧ^�n�J����
	} // end execute() 


	
	
	// �n�J��k
	public String login(){
	  System.out.println(LoginAction2.class.getName()+",login() ����F...");
		
	  return execute();   // �Ǧ^�D��k
	} // end login()
	
	
	
	
	// ���P��k
	public String logout(){
	  System.out.println(LoginAction2.class.getName()+",logout() ����F...");

	  return "logout";	// �Ǧ^�n�X����
	} // end logout()
	
	
	
	
	
	
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
