package com.spring.orm.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;

public class Client_transaction {

	
  public static void main(String[] args) {
	 
	// ���J�]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext_transaction.xml"));
    
    // ���o CatServiceImpl ������
    ICatService catService = (ICatService)factory.getBean("catService");
    
   
    Cat cat = new Cat();
    cat.setName("kitty's");
    cat.setCreateDate(new Date());
    
    // �x�s Cat ����
    catService.createCat(cat);
    System.out.println("\n");
    
    
    // �d�� Cat �ƶq
    int count = catService.getCatsCount();
    System.out.println("cat count = "+count);
    System.out.println("\n");
    
    // �C�X�Ҧ� Cat
    List<Cat> catList = catService.listCats();
    for(Cat c:catList){
      System.out.println("id         = "+c.getId());
      System.out.println("name       = "+c.getName());
      System.out.println("createDate = "+c.getCreateDate());
      
      System.out.println("\n");
    } // end for(Cat c:catList){

  } // end main

  
}
