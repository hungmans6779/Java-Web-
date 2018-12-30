package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="autoCompleteTag",
  results={
	@Result(name="success",location="/form/tags/UITag/autocompleteTag.jsp")	
})
public class AutoCompleteAction extends ActionSupport implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

	
  private ServletContext application;     // Servlet �W�U��
  private Map session;                    // session ����
  private HttpServletRequest request;     // request ����
  private HttpServletResponse response;   // response ����
	
  public void setServletContext(ServletContext application) {
    this.application = application;		
  }

  public void setSession(Map sessionValues) {
    this.session = sessionValues;
  }

  public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
  }

  public void setServletResponse(HttpServletResponse response) {
    this.response = response;
  }


  
  
  // List ����
  private List <String> provinceList = new ArrayList<String>(){
	{
	  add("�_��");  // �W�[���
	  add("�W��");  // �W�[���
	  add("�Ѭz");  // �W�[���
	  add("���y");  // �W�[���
	  add("�e�_");  // �W�[���
	  add("�e�n");  // �W�[���
	  add("�s�F");  // �W�[���
	  add("�s��");  // �W�[���
	  add("��Ĭ");  // �W�[���
	  add("����");  // �W�[���
	} 
  };
  
  
  
  // �D��k
  public String execute(){
	System.out.println(AutoCompleteAction.class.getName()+",execute()...");
	 
	request.setAttribute("provinceList1",provinceList);
	
	
	
	ServletContext application2 = ServletActionContext.getServletContext();
	HttpServletRequest request2 = ServletActionContext.getRequest();
	HttpServletResponse response2 = ServletActionContext.getResponse();
	HttpSession session1 = request2.getSession(true);
	request2.setAttribute("provinceList2",provinceList);
	
	
	
	return "success";
  } // end execute()

  
  
  
  


  public List<String> getProvinceList() {
	return provinceList;
  }

  public void setProvinceList(List<String> provinceList) {
	this.provinceList = provinceList;
  }
 
 
  
  
  
  
  
}
