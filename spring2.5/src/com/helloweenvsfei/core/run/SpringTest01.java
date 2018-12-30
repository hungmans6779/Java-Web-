package com.helloweenvsfei.core.run;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.core.service.IService;
import com.helloweenvsfei.core.service.IService2;

public class SpringTest01 {


	
	
  public static void main(String[] args) {
	
	  
	// *********************************************************************************************  
	
	// ���J�]�w��
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-core.xml"));

	// �q�]�w�ɤ���o����
	IService hello = (IService)factory.getBean("service");
	
	// ���� service ��k
	hello.service("Kevin01");
	
	// �P�����ͪ�Bean
	factory.destroySingletons();
	
	// *********************************************************************************************
	
	
	
	// ***********************************************************************************************
	// �m�ߥ�1
    ClassPathResource rs = new ClassPathResource("applicationContext-core.xml");
	XmlBeanFactory factory1 = new XmlBeanFactory(rs);  
    IService hello01_1 = (IService)factory1.getBean("service");
    hello01_1.service("kevinTest01-1");
	factory1.destroySingletons();
	// ***********************************************************************************************

	
	
	// ***********************************************************************************************
	// �m�ߥ�2(����2�ӥH�W�� Spring �]�w��)
	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
	  new String []{"applicationContext-core.xml","applicationContext-core1.xml"}
	);
	BeanFactory factory2 = (BeanFactory)appContext;
	
    IService hello02_1 = (IService)factory2.getBean("service");
	hello02_1.service("kevinTest02-1");
	
	IService2 hello02_2 = (IService2)factory2.getBean("service2");
	hello02_2.service("kevinTest02-2");
	// ***********************************************************************************************
	
  } // end public static void main(String[] args) {
  
  

}
