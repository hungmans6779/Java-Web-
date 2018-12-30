package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.dao.BaseDAO;

/**
 * Servlet implementation class CatServlet
 */
public class CatServlet extends HttpServlet {
	
  private static final long serialVersionUID = 1L;
   
  private BaseDAO <Cat> baseDAO  = new BaseDAO<Cat>();
	
	
	
 /**
   * @see HttpServlet#HttpServlet()
   */
  public CatServlet() {
    super();
  }

     
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
  }

	
  
  
	
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	/* 
	 * addCat.jsp  �ϥΪ���  catList �� cat
	 * listCat.jsp �ϥΪ���  msg �� catList
	 * viewCat.jsp �ϥΪ���  cat
	 */
	
	String action = request.getParameter("action");
	if("initAdd".equals(action)){
      initAdd(request,response);        // ��ܼW�[����                                          => addCat.jsp
	}else if("add".equals(action)){
	  add(request,response);            // �V��Ʈw�����J�@���s���            => listCat.jsp
	}else if("edit".equals(action)){
	  edit(request,response);           // ��ܭקﭶ��                                          => addCat.jsp
	}else if("save".equals(action)){
	  save(request,response);           // �N�ק�᪺����x�s�i��Ʈw	  => listCat.jsp
	}else if("view".equals(action)){
	  view(request,response);           // ��� id �������������O�ݩ�       => viewCat.jsp
	}else if("list".equals(action)){
	  list(request,response);           // ��ܩҦ����������O����	      => listCat.jsp
	}else if("delete".equals(action)){
	  delete(request,response);         // �R��id �������������O       	  => listCat.jsp
	}else{ 
	  list(request,response);           // �w�]��ܩҦ����������O����	  => listCat.jsp
	}
	

  } // end doPost
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  // ��ܼW�[����
  protected void initAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	List<Cat> catList = baseDAO.list("select c from Cat c");
	request.setAttribute("catList",catList);
	
	/*
    RequestDispatcher rd = request.getRequestDispatcher("/addCat.jsp");
    rd.forward(request, response);
    */
	request.getRequestDispatcher("/jsp/cat/addCat.jsp").forward(request,response);
  } // end initAdd
  
  
  
  
  
  
  

  // �V��Ʈw�����J�@���s���
  protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    int motherId = Integer.parseInt(request.getParameter("motherId"));
    String name=request.getParameter("name");
    String description = request.getParameter("description");
    
    Cat mother = baseDAO.find(Cat.class,motherId);
    
    Cat cat = new Cat();
    cat.setName(name);
    cat.setDescription(description);
    cat.setCreateDate(new Date());
    cat.setMother(mother);
    
    baseDAO.create(cat);  // ���J��ƪ�
    
    request.setAttribute("msg","�W�[ '"+cat.getName()+"' ���\...");
    
    list(request,response); // ��ܩҦ����������O����	
  } // end add
  
  
  
  
  
  
  

  // ��ܭקﭶ��
  protected void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	request.setAttribute("cat",cat);
	request.setAttribute("catList",baseDAO.list(" from Cat"));
	
    /*	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/addCat.jsp");
	rd.forward(request, response);
	*/
	request.getRequestDispatcher("/jsp/cat/addCat.jsp").forward(request, response);
  } // end edit
  
  
  
  
  
  
  

  // �N�ק�᪺����x�s�i��Ʈw	
  protected void save(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  
	int motherId = Integer.parseInt(request.getParameter("motherId"));
	  
	int id = Integer.parseInt(request.getParameter("id"));
	String name= request.getParameter("name");
	String description = request.getParameter("description");
	
	Cat mother = baseDAO.find(Cat.class,motherId);
	Cat cat = baseDAO.find(Cat.class,id);
	
	cat.setName(name);
	cat.setDescription(description);
	cat.setMother(mother);
	
	boolean hasLoop = false;
	Cat tmpMother = mother;
	while(tmpMother!=null){
	  if(tmpMother.getId().intValue() == cat.getId().intValue()){
		 hasLoop = true;
		 break;
	  } // end if(tmpMother.getId().intValue() == cat.getId().intValue()){ 
	  tmpMother = tmpMother.getMother(); // ���ߤ����S�� mother_id
	} // end while(tmpMother!=null){
	
	if(!hasLoop){
      baseDAO.update(cat);
      request.setAttribute("msg","�x�s  '"+cat.getName()+"' ���\...");
	}else{
	  request.setAttribute("msg","�x�s���ѡA�o�{�`��...");	
	}
	
	list(request,response); // ��ܩҦ����������O����	
  } // end save
  
  
  
  
  
  
  

  // ��� id �������������O�ݩ� 	
  protected void view(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	
	request.setAttribute("cat",cat);
	
    /*	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/viewCat.jsp");
	rd.forward(request,response);
	*/
	request.getRequestDispatcher("/jsp/cat/viewCat.jsp").forward(request,response);
  } // end view
  
  
  
  
  
  
  

  // ��ܩҦ����������O����	
  protected void list(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	request.setAttribute("catList",baseDAO.list(" from Cat"));
	
	/*
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/cat/listCat.jsp");
	rd.forward(request,response);
	*/
	request.getRequestDispatcher("/jsp/cat/listCat.jsp").forward(request,response);
  } // end list
  
  
  
  
  
  
  

  // �R��id �������������O
  protected void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	
	Cat cat = baseDAO.find(Cat.class,id);
	if(cat!=null){
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select c from Cat c                            \n");
      sqlStr.append("   where c.mother.id = '").append(id).append("'  \n");
    	 
	  List <Cat> catList = baseDAO.list(sqlStr.toString());
	  if(catList.size()>0){
		request.setAttribute("msg","�L�k�R�� ' "+cat.getName()+"' �C�Х��R���l Cat�C");  
	  }else{
		baseDAO.delete(cat);  
		request.setAttribute("msg","�R�� '"+cat.getName()+"' ���\...");
	  }
	  
	  list(request,response);
	} // end if(cat!=null){
	  
  } // end delete
  
  
	
	
}
