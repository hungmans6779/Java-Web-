/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.helloweenvsfei.struts.bean.Person;

/** 
 * MyEclipse Struts
 * Creation date: 06-04-2012
 * 
 * XDoclet definition:
 * @struts.form name="useBeanForm"
 */
public class UseBeanForm extends ActionForm {
	
	
	/*
	 * Generated Methods
	 */

	private Person person = new Person();  // POJO 類型，這裡要先產生實體一個物件(沒有宣告 new ，則會拋出 NullPointException)
	private String action;
	
	
	
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	
	
	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {

	  System.out.println("*********************************************");
      System.out.println(UseBeanForm.class.getName());
      System.out.println("action = "+action);
      System.out.println("person.account = "+person.getAccount());
      System.out.println("person.name    = "+person.getName());
      System.out.println("*********************************************");
            
	  return null;
	}

	
	
	
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	
	
}