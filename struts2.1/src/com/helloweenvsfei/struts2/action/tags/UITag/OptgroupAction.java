package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="optiongroupTag",results={
  @Result(name="success",location="/form/tags/UITag/optiongroupTag.jsp")		
})
public class OptgroupAction {

	
	
  // �@�Ÿ�Ʃ�� List ��	
  private List<String> cityList = new ArrayList<String>(){
	{
	  add("�_��");  // �W�[���	  
	  add("�W��");  // �W�[���
	  add("�Ѭz");  // �W�[���
	  add("���y");  // �W�[���
	}
  }; // end private List<String> cityList
  
  
  // �G�Ÿ�Ʃ�� Map ��	
  private Map<String,HashMap<String,String>> provinceMap = new HashMap<String,HashMap<String,String>>(){
	{
		
	  put("�s�F",new HashMap(){
		{
		  put("�٫n","�٫n");	// �W�[���	 
		  put("�C�q","�C�q");	// �W�[���	   
		  put("�ϥx","�ϥx");	// �W�[���	   
		  put("�d��","�d��");	// �W�[���	   
		  put("��{","��{");	// �W�[���	   
		}
	  });
	 
	  put("�e�_",new HashMap(){
		{
		  put("�ۮa��","�ۮa��");    // �W�[���	
		  put("��s","��s");        // �W�[���	
		  put("�ɦ{","�ɦ{");        // �W�[���	
		  put("���X","���X");        // �W�[���	
		}
	  });
	  
	} // end 
	
  }; // end private Map<String,HashMap<String,String>> provinceMap 

  

  // �D��k  
  public String execute(){
	System.out.println(OptgroupAction.class.getName()+",execute().....");
	
	return "success";
  } // end execute()
  
  
  
  
  
  public List<String> getCityList() {
	return cityList;
  }

  public void setCityList(List<String> cityList) {
	this.cityList = cityList;
  }

  public Map<String, HashMap<String, String>> getProvinceMap() {
	return provinceMap;
  }

  public void setProvinceMap(Map<String, HashMap<String, String>> provinceMap) {
	this.provinceMap = provinceMap;
  }
	
  
  
}
