package com.helloweenvsfei.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;




import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatService;

// �~�� AbstractController
public class  CatController extends AbstractController {
  
  private ICatService catService;      // service ����
   
  public ICatService getCatService() {
	return catService;
  }

  public void setCatService(ICatService catService) {
	this.catService = catService;
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
  protected ModelAndView add(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
	Cat cat = new Cat();
	cat.setName(request.getParameter("name"));
	cat.setCreateDate(new Date());
	
	catService.createCat(cat);

	return new ModelAndView("cat/listCat","cat",cat);  // �Ǧ^ cat/listCat ���� 
  } // end add
  
  
  
  // �C�X�Ҧ�Cat 
  protected ModelAndView list(HttpServletRequest request,HttpServletResponse reponse) throws Exception{
	List<Cat> catList = catService.listCat();
	request.setAttribute("catList",catList);	
	  
	return new ModelAndView("cat/listCat");    // �Ǧ^ cat/listCat ����
  } // end list
  

  
  
  
}
