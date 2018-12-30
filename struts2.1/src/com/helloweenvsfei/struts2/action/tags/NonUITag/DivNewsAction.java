package com.helloweenvsfei.struts2.action.tags.NonUITag;

import java.util.ArrayList;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


public class DivNewsAction {

  private static String [] ALL_NEWS = {
	"����N�|��2008�~���B�|, �}������� 2008�~8��8��",
	"�~���ߤ��, �S�@���B�ؿv���_��|�]��e���u", 
	"�߮Z����ìP���\�o�g�ɪ�", 
	"���ऻ�����t�z����ӧQ���",
	"����A�Ѫѥ��W�^�ϼu",   
  };
	
  
  private String key;
  private List<String> news = new ArrayList<String>();
  
  
  
  // �D��k
  public String execute(){
	key = (key==null)?"":key;

	// �ˬd�s�D���D
	for(String n:ALL_NEWS){
	  if(n.contains(key)){ // �]�t����r 
		news.add(n); 
	  }
	} // end for(String n:ALL_NEWS){

	return "success";  
  } // end execute() 


  
  
  public String getKey() {
	return key;
  }

  public void setKey(String key) {
	this.key = key;
  }

  public List<String> getNews() {
	return news;
  }

  public void setNews(List<String> news) {
	this.news = news;
  }
  
  
  
  
  
  
  
}
