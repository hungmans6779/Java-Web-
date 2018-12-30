package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@Namespace(value="/tags")
@Action(value="optiontransferselectTag",results={
  @Result(name="success",location="/form/tags/UITag/optiontransferselectTag.jsp")		
})
public class OptiontransferselectAction extends ActionSupport {

  // �Ŀ諸�٥���List
  private List<String> provinceSelected = new ArrayList<String>(){
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
  }; // end private List<String> provinceSelected 
  
  
  
  // �S���Ŀ諸�٥� List
  private List <String> provinceUnselected = new ArrayList<String>(){
	{
	  add("��n");  // �W�[���	  
	  add("��_");  // �W�[���	 
	  add("���n");  // �W�[���	 
	  add("�s�F");  // �W�[���	 
	  add("�s��");  // �W�[���	 
	}
  };  // end private List <String> provinceUnselected

  

  // �D��k
  public String execute(){
	System.out.println(OptiontransferselectAction.class.getName()+",execute()...");
	
	return "success"; 
  } // end execute()

  
  
  
  
  public List<String> getProvinceSelected() {
	return provinceSelected;
  }

  public void setProvinceSelected(List<String> provinceSelected) {
	this.provinceSelected = provinceSelected;
  }

  public List<String> getProvinceUnselected() {
	return provinceUnselected;
  }

  public void setProvinceUnselected(List<String> provinceUnselected) {
	this.provinceUnselected = provinceUnselected;
  }
  
  
  
  
	
}
