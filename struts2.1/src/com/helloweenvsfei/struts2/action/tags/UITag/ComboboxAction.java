package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="comoboboxTag",
  results={
	@Result(name="success",location="/form/tags/UITag/comboboxTag.jsp")	
})
public class ComboboxAction extends ActionSupport {

  private List<String> favouriteList = new ArrayList<String>(){
	{
	  add("ī�G");  // �W�[���
	  add("��l");  // �W�[���
	  add("��");    // �W�[���
	  add("����");  // �W�[���	    
	}
  };
	
  
  public String execute(){
	System.out.println(ComboboxAction.class.getName());
	
	return "success";  
  }


  public List<String> getFavouriteList() {
	return favouriteList;
  }


  public void setFavouriteList(List<String> favouriteList) {
	this.favouriteList = favouriteList;
  }
  
  
  
  
}

