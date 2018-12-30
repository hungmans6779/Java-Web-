/*
 *  BeanFactoryAware ������JavaBean ���D����BeanFactory ���͹���F�ۤv�C
 *  BeanFactoryAware ��������setBeanFactory ���^�ɤ�k�A��l�ƸӪ����A�|�^�ɸӤ�k�A�NBeanFactory �ǻ��i�ӡC
 *  
 *  ��{�FBeanFactoryAware������JavaBean�����oBeanFactory�A�qBeanFactory �������o���BeanFactory���]�w����LJavaBean�C
 *  Spring�����˳o�˰��A�]���o�˷|�PSpring���X�C��o��LJavaBean�@��z�L�]�wgetter�Bsetter��k�A�ά̴ۨӤJ��{�C
 */
package com.helloweenvsfei.core.aware;

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("a")
public class A implements BeanFactoryAware {

  @Autowired
  @Qualifier("b")
  private B b;
	
  private BeanFactory factory;	
  
  /**
   * @return the b
   */
  public B getB() {
	return (B)factory.getBean("b");
  }

  /**
   * @param b the b to set
   */
  public void setB(B b) {
	this.b = b;
  }

  public void printB(){
	 System.out.println(getB()); 
  }
  
  
 
  // �e���b��Ҥƹ�{�FBeanFactoryAware ���f��Bean �ɡA�|�۰ʱN�e�������`�J��Bean
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.factory = beanFactory;
  }
  
  

}
