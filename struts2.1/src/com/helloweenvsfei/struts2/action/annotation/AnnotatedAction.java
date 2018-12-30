package com.helloweenvsfei.struts2.action.annotation;

import org.apache.struts2.convention.annotation.Namespace;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.opensymphony.xwork2.ActionSupport;

/*
 *  �s�]�w(zero configuration) ���N�䤣�O����]�w�ɧG�p Struts2 ���ΡA�p  struts.xml�Bstruts.properties�Bvalidation.xml ���C
 *  �s�]�w�ä��O�u��"�s�]�w"�A�u�O�S���ǲΪ��]�w�� struts.xml �F�A���O���ݭn�ϥ� @Annotation �]�w�C @Annotation ½Ķ��@�����B @�аO�A
 *  ���Ǹ�Ƥ]��Ķ�� @�����C
 */



// �R�W�Ŷ�
@Namespace(value = "/useAnnotationNamespace")
@Action("annotationAction")
@Results({  // ���G��(3�ӵ��G����)
  @Result(name="login",   location="/form/annotated/login.jsp"),
  @Result(name="success", location="/form/annotated/success.jsp"),
  @Result(name="redirect",location="/form/annotated/redirect.jsp")
})
public class AnnotatedAction extends ActionSupport {

	private String account;
	private String password;

	
	// �D��k
	public String execute() {	
	  System.out.println(AnnotatedAction.class.getName()+",execute()");
		 
      System.out.println("********************************************");
	  System.out.println(AnnotatedAction.class.getName());
	  System.out.println("01. account = "+account);
	  System.out.println("02. password = "+password);
	  System.out.println("********************************************");

	  if("kevin".equals(account) && "1234".equals(password)){
		return add();  
	  }
	  return LOGIN;
	} // end execute()

	
	
	public String add() {
	  System.out.println(AnnotatedAction.class.getName()+",add()");

	  return SUCCESS;
	} // end add

	
	
	public String login() {
	  System.out.println(AnnotatedAction.class.getName()+",login()");
	  
	  return execute();
	} // end login

	
	
	public String redirect() {
      System.out.println(AnnotatedAction.class.getName()+",redirect()");  
	  return "redirect";
    } // end login
	
	
	
	
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
