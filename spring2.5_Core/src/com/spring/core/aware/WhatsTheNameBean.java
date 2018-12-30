package com.spring.core.aware;

import org.springframework.beans.factory.BeanNameAware;

/*
 *  BeanNameAware ������  JavaBean ���D�ۤv�b�]�w�ɤ���id �C��{ BeanNameAware �����A��{��k�L�� setBeanName() ��k�A
 *  ��l�ƸӪ���� Spring �N�|����Ӧ^�ɤ�k�A�N id �]�w�i�ӡCBean ���]�w�@�Ӽg�{���A���� id �W�٧Y�i�C
 */
public class WhatsTheNameBean implements BeanNameAware {

  private String beanName;                    // �P�� Bean ���W�r
	  
  public void setBeanName(String beanName) {  // �x�s�W�r
    System.out.println(WhatsTheNameBean.class.getName()+",setBeanName execute...");
    System.out.println("beanName = "+beanName);
    
	this.beanName=beanName;                    // Spring �|�I�s�Ӥ�k   
  }

  public void showBean(){
	System.out.println(this.beanName);  
  }
	  
}