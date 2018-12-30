package com.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;

public class Client {

  
  public static void main(String[] args) {

	// ���J�]�w��
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	// CatDao ����
	ICatDao catDao = (ICatDao)factory.getBean("catDao");
	

	
	
	Cat cat = new Cat();
	cat.setName("kevin's cat");
	cat.setCreateDate(new Date());
	
	
	// �x�s����
	catDao.createCat(cat);  // �x�s����
	System.out.println("\n");
	
	
	// �d�ߩҦ���Cat ����
	List<Cat> catList = catDao.listCats();
	for(Cat c:catList){
	  System.out.println("id�G"+c.getId());
	  System.out.println("name�G"+c.getName());
	  System.out.println("createDate�G"+c.getCreateDate());
	  
	  System.out.println("\n");
	} // end for(Cat c:catList){
	System.out.println("\n");
	 
	
	// �Ǧ^����ƶq
	int count = catDao.getCatsCount();
	System.out.println("���o�`���� count�G"+count);
	System.out.println("\n");
	 
	
	// �ھڦW�r�d�ߪ���
	Cat cat1 = catDao.findCatByName("kevin's cat");
	System.out.println("cat1 name = "+cat1.getName());
	System.out.println("\n");
	 
	
	
  } // end main
  
  

}
