/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;
import com.struts.form.Cat2Form;

/**
 * MyEclipse Struts Creation date: 12-27-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/cat2" name="cat2Form" input="/form/listCat2.jsp"
 *                scope="request" validate="true"
 */
public class Cat2Action extends Action {

	private ICatService catService;

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}

	
	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) {
	  System.out.println(Cat2Action.class.getName()+",execute()  execut...");
	  
	  
	  Cat2Form cat2Form = (Cat2Form) form;

	  if("add".equals(cat2Form.getAction())){
         return this.add(mapping,form,request,response);   // 增加 Cat 物件   
	  }else{
		return this.list(mapping,form,request,response);   // 增加 Cat 物件
	  }
	} // end execute
	
	
	
	
	// 增加 Cat 物件
	private ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){  
	  System.out.println(Cat2Action.class.getName()+",add()  execut...");
		
	  Cat2Form cat2Form = (Cat2Form)form;
  
	  Cat cat = new Cat();
	  cat.setName(cat2Form.getName());
	  cat.setCreateDate(new Date());
	  
	  catService.createCat(cat); // 儲存 Cat 物件
	  
	  return this.list(mapping,form,request,response);   // 列出所有的 Cat 物件
	} // end add
	
	
	
	
	// 列出所有的 Cat 物件
	private ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
	  System.out.println(Cat2Action.class.getName()+",list()  execut...");
		
	  List<Cat> cat2List = catService.listCats();

      // 將 List Cat 物件放入 request 中
      request.setAttribute("catList",cat2List);
	  
	  return mapping.findForward("list");  // 傳回 list 頁面
    } // end list
	
	
	
	
}