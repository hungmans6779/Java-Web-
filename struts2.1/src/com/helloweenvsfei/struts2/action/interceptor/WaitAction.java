package com.helloweenvsfei.struts2.action.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class WaitAction extends ActionSupport {

	
  // �D��k
  public String execute() throws Exception{
	Thread.sleep(10000);  // ����10�� 
	
	return "success";  
  } // end execute()
  
  
}
