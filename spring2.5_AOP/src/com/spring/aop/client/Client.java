package com.spring.aop.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.spring.aop.service.IAopService;

/*
 *  ���d�ҡG���O���� Service ����Ӥ�k withAop() �P withoutAop()�C
 *  Spring �N�|�b withAop() ��k�e��W�[�d�I���A�� withoutAop() ��k�e��h���|�W�[�C
 */
public class Client {
  
  public static void main(String [] args) throws Exception{
	  
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	IAopService aopServiceBean = (IAopService)factory.getBean("aopService");
	
	System.out.println("����������������������������������������������������������������������������������������");
	System.out.println("�I�s aopServiceBean.withAop() Method .....\n");
	aopServiceBean.withAop();
	System.out.println("����������������������������������������������������������������������������������������");
	System.out.println("�I�s aopServiceBean.withoutAop() .....\n");
	aopServiceBean.withoutAop();
	System.out.println("����������������������������������������������������������������������������������������");
	System.out.println("�I�s factory.destroySingletons() Method .....\n");
	factory.destroySingletons();
	System.out.println("����������������������������������������������������������������������������������������");
	
  } // end main
  
}
