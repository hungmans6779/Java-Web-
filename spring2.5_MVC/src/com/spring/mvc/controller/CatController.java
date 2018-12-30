package com.spring.mvc.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;


/*
 *  Spring ����h
 *  
 *  
 *  Spring MVC �̨ϥ� Controller �B�z�ϥΪ��ШD�C 
 *  Controller �۷��� Struts1.x �̪� Action �A���̹�{����B�����z�������C
 *  
 *  
 *  Spring MVC ������h�O Contoller �CController �O�Ӥ����A�@�몽���~�� org.springframework.web.servlet.mvc.AbstractController�A
 *  �ù�{ handleRequestInternal ��k�C handleRequestInternal ��k�۷��� Struts1.x  Action �� execute() ��k�C
 *  
 *  
 *  Spring MVC ���u���I
 *   
 *  �@�� Spring ���@�����AController �㦳�ѵM���u�աA���ݹ� Struts1 & 2 �� Action ���˯S�N��X�N��ĤJ Spring �{�� Framework ���C
 *  catService �ϥ� IoC �ӤJ�� Controller ���C 
 *   
 *  handleRequestInternal ��k�ѼƬ� request�Bresponse �A�o�˥i�H�q request ����o��ơA�� Servlet �@�˾ާ@�C 
 *  
 *  
 *
 *  
 *  
 *  Spring MVC �W�S���a��b�� View �h���B�z�W�C handleRequestInternal �Ǧ^ ModelAndView ����A�۷��� Struts1.x �̪� ActionForward�C
 * 
 *  �� ModelAndView�G
 *     ��i�H�ݰ��O��JSP ���󪺫ʸˡCModelAndView ��������JSP ���������|�A�Ҧp new ModelAndView("cat/list")�C
 *     �Ѽ� "cat/list" �u�O JSP ���|���@�����A���㪺���|�� "/WEB-INF/jsp/cat/listCat.jsp" �A���|���e�᳡���O�]�w�b�]�w�ɤ��C 
 *     
 *  �� �ǻ��ѼơG
 *     ���F���w JSP ���|�A ModelAndView �٥i�H�����ǻ� Model ����� View �h�A�Ӥ��Υ���� request ���C
 *     �Ҧp new ModelAndView("cat/listCat","cat",cat) �A
 *     ���� 
 *     request.setAttribute("cat",cat);
 *     return new ModelAndView("cat/listCat");
 *  
 *  �� �ǻ��h�ӰѼ�
 *     Map map = new HashMap(); 
 *     map.put("cat",cat);
 *     map.put("catList",catList);
 *     return new ModelAndView("cat/listCat",map);   // ��^ ModelAndView
 *
 */
public class CatController extends AbstractController{

  // service ����	
  private ICatService catService;
  
  public ICatService getCatService() {
	return catService;
  }

  public void setCatService(ICatService catService) {
	System.out.println(CatController.class.getName()+",catService = "+catService);
	this.catService = catService;
  }

  
  
  
	
  // handleRequestInternal ��k�۷��� Struts1.x  Action �� execute() ��k�C
  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
	System.out.println(CatController.class.getName()+",handleRequestInternal()  execute...");
	 
	String action = request.getParameter("action");
    if("add".equals(action)){	
      return this.add(request,response);
    }else{
      return this.list(request,response);	
    }
  } // end handleRequestInternal
  

  
  
  // �x�s Cat 
  protected ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws Exception {	
	System.out.println(CatController.class.getName()+",add() execute...");
	  
	// �إ� Cat ����
	Cat cat = new Cat();
	cat.setName(request.getParameter("name"));
	cat.setCreateDate(new Date());
	
	// �x�s Cat ����
	catService.createCat(cat);  
	
	return new ModelAndView("cat/listCat","cat",cat);   // �Ǧ^ cat/listCat ����
  } // end add 
  
  
  
  
  
  // �C�X�Ҧ��� Cat
  protected ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception {
	System.out.println(CatController.class.getName()+",list() execute...");
	  
	// �C�X�Ҧ� Cat
	List<Cat> catList = catService.listCats();
	request.setAttribute("catList",catList); 
	
	return new ModelAndView("cat/listCat");             // �Ǧ^ cat/listCat ����
  } // end list
  
  
  
  



  
  
	
}