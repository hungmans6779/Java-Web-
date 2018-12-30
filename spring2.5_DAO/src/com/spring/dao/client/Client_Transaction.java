package com.spring.dao.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.dao.transaction.TransactionRun;

public class Client_Transaction {

	
  public static void main(String[] args) {
		
	// ���J�]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
    
    // ���o Bean 
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRun");
    
    // �D��k�A�� Spring �I�s
    tr.run();
  } // main

}
