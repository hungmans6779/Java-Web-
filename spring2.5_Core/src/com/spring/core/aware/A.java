package com.spring.core.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*
 *  BeanFactoryAware ������JavaBean ���D����BeanFactory ���͹���F�ۤv�C
 *  BeanFactoryAware ��������setBeanFactory ���^�ɤ�k�A��l�ƸӪ����A�|�^�ɸӤ�k�A�NBeanFactory �ǻ��i�ӡC
 *  
 *  ��{�FBeanFactoryAware������JavaBean�����oBeanFactory�A�qBeanFactory �������o���BeanFactory���]�w����LJavaBean�C
 *  Spring�����˳o�˰��A�]���o�˷|�PSpring���X�C��o��LJavaBean�@��z�L�]�wgetter�Bsetter��k�A�ά̴ۨӤJ��{�C
 */
@Component("a")
public class A implements BeanFactoryAware {

  @Autowired
  @Qualifier("b")
  private B b;

  private BeanFactory factory;
  
  
  public B getB() {
	System.out.println(BeanFactoryAware.class.getName()+",getB()  execute...");
	return (B)factory.getBean("b");
  }

  public void setB(B b) {
	System.out.println(BeanFactoryAware.class.getName()+",setB()  execute...");
	this.b = b;
  }

  
  public void printB(){
	System.out.println(BeanFactoryAware.class.getName()+",printB()  execute...");
	System.out.println(getB()); 
  }

  
  
  // �e���b��Ҥƹ�{�FBeanFactoryAware ���f��Bean �ɡA�|�۰ʱN�e�������`�J��Bean
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	System.out.println(BeanFactoryAware.class.getName()+",setBeanFactory()  execute...");
	System.out.println("beanFactory = "+beanFactory);
	System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	
	this.factory = beanFactory;
  } // end setBeanFactory
  
  
  
  
  
}
