package com.helloweenvsfei.struts2.action.tags.NonUITag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="divLoginTag",
        results={
          @Result(name="input",location="/form/tags/NonUITag/divLogin.jsp"),
          @Result(name="script",location="/form/tags/NonUITag/divLoginScript.jsp")
})
public class DivLoginAction extends ActionSupport {

	
  private String username;  // �ϥΪ̦W��
  private String password;  // �ϥΪ̱K�X
  
  
  
  // �D��k	
  public String execute(){
	System.out.println(DivLoginAction.class.getName()+",execute()...");
	
	return "input";    //  �Ǧ^��J����
  } // end execute()
  
  
  
  
  
  // login �n����k
  public String login(){
	System.out.println(DivLoginAction.class.getName()+",�n�J login()...");
	System.out.println("username = "+username);  
	System.out.println("password = "+password);
  
	HttpServletRequest  request = ServletActionContext.getRequest();
	HttpSession session = request.getSession(true);
	
	if("kevin".equals(username) && "1234".equals(password)){
	  session.setAttribute("username",username);
	  request.setAttribute("status","success");  // �аO�����\
	}else{
	  request.setAttribute("status","failed");   // �аO������
	}
	
	return "script";  // �Ǧ^���O�Z����
  } // end login()
  
  
  
  
  
  
  
  // logout �n�X��k
  public String logout(){
    System.out.println(DivLoginAction.class.getName()+",�n�X logout()...");  
 	HttpServletRequest  request = ServletActionContext.getRequest();
 	HttpSession session = request.getSession(true);
 	
    session.removeAttribute("username");
    request.setAttribute("status","logout");   // �аO���n�X
 
	return "input";                          // �Ǧ^���O�Z����
  } // end logout()




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
  
  
  
}
