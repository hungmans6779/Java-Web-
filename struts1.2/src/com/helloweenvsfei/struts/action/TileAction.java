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
import com.helloweenvsfei.struts.form.TileForm;

/** 
 * MyEclipse Struts
 * Creation date: 09-10-2012
 * 
 * XDoclet definition:
 * @struts.action path="/tile" name="tileForm" input="/form/tile.jsp" scope="request" validate="true"
 */
public class TileAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
	  TileForm tileForm = (TileForm) form;
	
	  String action = tileForm.getAction();
	  
	  System.out.println("**********************************");
	  System.out.println(TileAction.class.getName());
	  System.out.println("01.action = "+action);
	  System.out.println("**********************************");
	  
	  if("list".equals(action)){
		return mapping.findForward("list");
	  }else if("view".equals(action)){
		return mapping.findForward("view");
	  }else{
		return mapping.getInputForward(); 
	  }
	  
	} // end execute
	
	
	
}