package com.helloweenvsfei.struts2.action.tags.controlTags;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.helloweenvsfei.struts2.action.bean.Magazine;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/tags")
@Action(value="iteratorTag",
        results={
		  @Result(name="success",location="/form/tags/controlTag/iteratorTag.jsp") 
        }
)
public class IteratorAction extends ActionSupport{
	
  @SuppressWarnings("all")
  private List <Magazine> magazineList= new ArrayList<Magazine>(){
	{ 
	  add(new Magazine("�ɥN�P�Z",10));
	  add(new Magazine("���y���]",19));
	  add(new Magazine("�ɩ|",20));
	  add(new Magazine("�ɥN�v��",50));
	}
  }; // end 

  
  public List<Magazine> getMagazineList() {
	return magazineList;
  }

  
  public void setMagazineList(List<Magazine> magazineList) {
	this.magazineList = magazineList;
  }
  
 
}
