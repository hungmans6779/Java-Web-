/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.helloweenvsfei.struts.form.ValidatorForm;


/** 
 * MyEclipse Struts
 * Creation date: 09-11-2012
 * 
 * XDoclet definition:
 * @struts.action path="/validator" name="validatorForm" input="/form/validator.jsp" scope="request" validate="true"
 */
public class ValidatorAction extends Action {

	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
	  ValidatorForm validatorForm = (ValidatorForm) form;
		
	  return mapping.getInputForward();
	} // end execute
	
	
	
}