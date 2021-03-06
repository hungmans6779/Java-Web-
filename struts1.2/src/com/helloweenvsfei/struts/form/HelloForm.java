/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.form;

import java.sql.Time;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 05-28-2012
 * 
 * XDoclet definition:
 * @struts.form name="helloForm"
 */
public class HelloForm extends ActionForm {
	
	/*
	 * Generated fields
	 */

	/** name property */
	private String name;        // String 類型
	private int age;            // 年齡
	private boolean experience; // 是否使用過 Struts
	private String [] hobby;    // 愛好
	private Date date;          // 日期 
	private Time time;          // 時間 
	 

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request){
		
	  ActionErrors errors = new ActionErrors();   // 儲存所有的錯誤資訊
	
	  
	  System.out.println("*****************************************");
	  System.out.println(HelloForm.class.getName());
	  System.out.println("name       = "+name);
	  System.out.println("age        = "+age);
	  System.out.println("experience = "+experience);
	  System.out.println("hobby      = "+Arrays.toString(hobby));
	  System.out.println("date       = "+date);
	  System.out.println("time       = "+time);
	  System.out.println("*****************************************");
	  
		
	  if(name == null || name.trim().length()==0){  // 如果 name 為空
		System.out.println(HelloForm.class.getName()+" validate() ！！！");
		
		errors.add("name",new ActionMessage("hello.error.name"));	
	  }
		
	  if(hobby == null || hobby.length < 1){        // 如果 hobby 陣列為空
		errors.add("hobby",new ActionMessage("hello.error.hobby"));
	  }
		
	  if(age < 5){                                  // 如果 age 小於5
		errors.add("age",new ActionMessage("hello.error.age",12,65));	
	  }
			
	  System.out.println("errros size = "+errors.size());
	  return errors;  // 如果 errors 為 null 時，則執行 ActionBean 的 execute() Method
	} // end validate

	
	
	
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	// 用於資料初始化
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	  age=34;  // 初始化資料
	}

	
	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the experience
	 */
	public boolean isExperience() {
		return experience;
	}


	/**
	 * @param experience the experience to set
	 */
	public void setExperience(boolean experience) {
		this.experience = experience;
	}


	/**
	 * @return the hobby
	 */
	public String[] getHobby() {
		return hobby;
	}


	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}


	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}