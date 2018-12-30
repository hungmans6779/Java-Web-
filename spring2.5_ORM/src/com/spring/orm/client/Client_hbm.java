package com.spring.orm.client;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;


public class Client_hbm {

  public static void main(String[] args) {
    
	System.out.println(Client_hbm.class.getName()+",main() execute...");
	  
	  
	// ���J�]�w��
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_hbm.xml"));
	
	
	// Cat DAO ����
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
	 	 
  } // end main
  

}
