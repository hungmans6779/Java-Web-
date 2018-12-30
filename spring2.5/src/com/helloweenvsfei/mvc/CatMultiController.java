package com.helloweenvsfei.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatService;

public class CatMultiController extends MultiActionController {

	private ICatService catService;

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
		System.out.println("ddd1 = "+catService);
	}

	
	
	// �D��k
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
	  String action = request.getParameter("action");
	  if("add".equals(action)){
	    return this.add(request,response);
	  }
	  return this.list(request,response);
	}
	 
	
	
	// �x�s Cat
	@SuppressWarnings("unchecked")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  Cat cat = new Cat();
	  cat.setName(request.getParameter("name"));
	  cat.setCreateDate(new Date());
	  
	  System.out.println("kevintest catService = "+catService);
	  
	  
	  catService.createCat(cat);

	  return this.list(request, response);
	} // end add
	
	
	
	
	
	// �C�X�Ҧ�Cat 
	@SuppressWarnings("unchecked")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  List<Cat> catList = catService.listCat();
	  request.setAttribute("catList",catList);
	  
	  return new ModelAndView("cat/listCat");    // �Ǧ^ cat/listCat ����
	} // end list
	
	
	
	
	
}
