/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.action;

import java.sql.Connection;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.helloweenvsfei.struts.bean.Person;
import com.helloweenvsfei.struts.bean.Person1;
import com.helloweenvsfei.struts.dao.PersonDAO;
import com.helloweenvsfei.struts.form.TagForm;

/** 
 * MyEclipse Struts
 * Creation date: 10-13-2011
 * 
 * XDoclet definition:
 * @struts.action path="/tag" name="tagForm" input="/form/tag.jsp" scope="request" validate="true"
 */
public class TagAction extends Action {
	
	
	
	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception{	
		
	  TagForm tagForm = (TagForm) form;	

	  System.out.println("**************************************************");
	  System.out.println(TagAction.class.getName());
	  System.out.println("1.checkbox   = "+tagForm.getCheckbox());
	  // System.out.println("2.file       = "+tagForm.getFile());
	  System.out.println("3.hidden     = "+tagForm.getHidden());
	  System.out.println("4.multibox   = "+Arrays.toString(tagForm.getMultibox()));
	  System.out.println("5.password   = "+tagForm.getPassword());
	  System.out.println("6.radio      = "+tagForm.getRadio());
	  System.out.println("7.select     = "+tagForm.getSelect());
	  System.out.println("8.text       = "+tagForm.getText());
	  System.out.println("9.textarea   = "+tagForm.getTextarea());
	  System.out.println("**************************************************");
	  
	  tagForm.setCheckbox("音樂");
	  tagForm.setHidden("隱藏的文字域");
	  tagForm.setMultibox(new String[]{"選項一","選項二"});
	  tagForm.setPassword("這裡是密碼");
	  tagForm.setRadio("男");
	  tagForm.setSelect("選項五");
	  tagForm.setText("這裡是文字域");
	  tagForm.setTextarea("這裡是一段文字\r\n這是第二行！");

	  PersonDAO personDAO = new PersonDAO();                       // PersonDAO 值
	  Connection conn = getDataSource(request).getConnection();    // 從 Struts 中獲得資料來源
	  List <Person1> personList = personDAO.listPersons(conn);     // 獲得所有的  Person
	  
	  request.setAttribute("personList", personList);
	
	  return mapping.getInputForward();
	  
	} // end execute
	
	
	
	
}
