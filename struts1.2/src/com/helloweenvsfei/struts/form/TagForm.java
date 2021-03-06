/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.helloweenvsfei.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;


/**
 * MyEclipse Struts Creation date: 10-13-2011
 * 
 * XDoclet definition:
 * 
 * @struts.form name="tagForm"
 */
public class TagForm extends ActionForm {

	private String checkbox;    // 多選框 checkbox
	// private FormFile file;      // 檔案域
	private String hidden;
	private String [] multibox; // 多選框 multibox 
    private String password;  
    private String radio;       // 對應表單的 radio 單選框域
    private String select;      // 對應表單的 select 下拉清單域
    private String text;        // 對應表單的 text 輸入框域
    private String textarea;    // 對應表單的 textarea 文字區域
    
	/**
	 * @return the hobby
	 */
	public String getCheckbox() {
		return checkbox;
	}

	/**
	 * @param hobby the hobby to set
	 */
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	
	
	/**
	 * @return the file
	 */
	/*
	public FormFile getFile() {
		return file;
	}
	*/

	/**
	 * @param file the file to set
	 */
	/*
	public void setFile(FormFile file) {
		this.file = file;
	}
	*/


	/**
	 * @return the hidden
	 */
	public String getHidden() {
		return hidden;
	}

	/**
	 * @param hidden the hidden to set
	 */
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	
	/**
	 * @return the multibox
	 */
	public String[] getMultibox() {
		return multibox;
	}

	/**
	 * @param multibox the multibox to set
	 */
	public void setMultibox(String[] multibox) {
		this.multibox = multibox;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the radio
	 */
	public String getRadio() {
		return radio;
	}

	/**
	 * @param radio the radio to set
	 */
	public void setRadio(String radio) {
		this.radio = radio;
	}

	/**
	 * @return the select
	 */
	public String getSelect() {
		return select;
	}

	/**
	 * @param select the select to set
	 */
	public void setSelect(String select) {
		this.select = select;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the textarea
	 */
	public String getTextarea() {
		return textarea;
	}

	/**
	 * @param textarea the textarea to set
	 */
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	/**
	 * Method validate
	 * 
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	// 傳送資料時用於資料驗證
	// ActionErrors 為null 或者沒有ActionMessage 記錄，則認證通過
	// 如果ActionErrors 內有ActionMessage 記錄，則沒有通過驗證，資料不會傳送給Action，也不會執行Action 的 execute()方法
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		

	  return null;
	}

	
	
	
	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	// 用於重置資料(初始化資料)
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	
	


}