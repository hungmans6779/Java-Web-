package com.helloweenvsfei.struts.action.special;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DogAction extends Action {

	
  public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){

	System.out.println(DogAction.class.getName()+" ActionForward execute() �I�I�I");
		 
	// ��� success �����A�]�N�O /form/special/DogSuccess.jsp �����A�]�w�b struts-config.xml ��
	return mapping.findForward("success"); 
  } // end execute
  
}
