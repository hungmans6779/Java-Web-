package com.helloweenvsfei.struts2.action.tags.NonUITag;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="errorTag",
        results={
		  @Result(name="success",location="/form/tags/NonUITag/errorInputTag.jsp")
}) 
public class ErrorAction extends ActionSupport {


  // �D��k
  public String execute(){
	System.out.println(ErrorAction.class.getName()+",execute()...");
	
	return "success";
  } // end execute()
  
  
  
  
  // error ��k�C(�W�[ ActionError) 
  public String error(){
	System.out.println(ErrorAction.class.getName()+",error()...");
	
	this.addActionError("���� error() ��k�A�ߥX�F�Ĥ@�� error �T���C");
	this.addActionError("���� error() ��k�A�ߥX�F�ĤG�� error �T���C");
	  
	return "success";  // �Ǧ^��J����
  } // end error()
  
  
  
  
  // message ��k�C(�W�[ ActionMessage) 
  public String message(){
	System.out.println(ErrorAction.class.getName()+",message()...");  
	  
    this.addActionMessage("���� message() ��k�A�ߥX�F�Ĥ@�� message �T���C");
    this.addActionMessage("���� message() ��k�A�ߥX�F�ĤG�� message �T���C");
    
	return "success";  // �Ǧ^��J����
  } // end message
  
  
  
  
  // fieldError ��k�C(�W�[ FieldError) 
  public String fieldError(){
	System.out.println(ErrorAction.class.getName()+",fieldError()...");  

	this.addFieldError("username","�ж�g�ϥΪ̦W��");
	this.addFieldError("password","�K�X���ର��");    
	  
	return "success";  // �Ǧ^��J����
  } // end fieldError()
  
  
  
}
