package com.helloweenvsfei.orm.run;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;

public class ORMRun {

	
  public static void main(String [] args){
	  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-orm.xml"));  
	ICatDao catDao = (ICatDao) factory.getBean("catDao");
	
	Cat cat = new Cat();
	cat.setName("Hello Kitty");
	cat.setCreateDate(new Date()); 
	
	
	catDao.createCat(cat);                                           // �x�s����	
	

	List <Cat> catList = catDao.listCats();                          // �d�ߩҦ�����
	for(Cat c:catList){
	  System.out.println("Name�G"+c.getName());	
	} // end for(Cat c:catList){
	
	
	System.out.println("�Ҧ����󪺼ƶq�G"+catDao.getCatsCount());     // �Ǧ^����ƶq
	
	
    Cat cat1 = catDao.findCatByName("Hello Kitty");                  // �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
    System.out.println("Hello Kitty => id = "+cat1.getId()+" , name = "+cat1.getName());
    
  }
  
  
  
}
