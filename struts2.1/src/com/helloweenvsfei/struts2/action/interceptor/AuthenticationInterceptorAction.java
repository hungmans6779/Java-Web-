package com.helloweenvsfei.struts2.action.interceptor;

import com.opensymphony.xwork2.ActionSupport;


public class AuthenticationInterceptorAction extends ActionSupport {

  private String message;

  
  // �D��k 
  public String execute() {
	message = "�z���b�s�� AuthenticationAction. ";

	return "success";
  } // end execute()
  

  public String getMessage() {
		return message;
  }

  public void setMessage(String message) {
		this.message = message;
  }
  
  
}
