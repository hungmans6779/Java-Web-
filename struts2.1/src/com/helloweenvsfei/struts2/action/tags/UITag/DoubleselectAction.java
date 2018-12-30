package com.helloweenvsfei.struts2.action.tags.UITag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/tags")
@Action(value="doubleselectTag",
  results={
	@Result(name="success",location="/form/tags/UITag/doubleselectTag.jsp")	
})
public class DoubleselectAction {
	
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
	  add("�X�� ");  // �W�[���
	}
  }; // end List <String> provinceList
  
  
  
  // Map ����
  private Map<String,List<String>> cityMap = new HashMap<String,List<String>>(){
	{
		
      // ��� map ����
	  put("�_��",new ArrayList<String>(){
		{
		  add("�F����");
		  add("�諰��");
		  add("������");
		  add("�¶���");
		}
	  });
	  
	  // ��� map ����
	  put("�s�F",new ArrayList<String>(){
		{
		  add("�C�q");  
		  add("�٫n");
		  add("��{");
		  add("�ϥx");
		  add("�d��");	  
		}
	  });

	}
	
  }; // end Map<String,List<String>> cityMap 
  
  
  
  
  
  // �D��k
  public String execute(){
	System.out.println(DoubleselectAction.class.getName()+",execute().....");
	
	return "success";
  } // end execute()



  

  public List<String> getProvinceList() {
	return provinceList;
  }

  public void setProvinceList(List<String> provinceList) {
	this.provinceList = provinceList;
  }

  public Map<String, List<String>> getCityMap() {
	return cityMap;
  }

  public void setCityMap(Map<String, List<String>> cityMap) {
	this.cityMap = cityMap;
  }
  

  
  
  
  
  
}
