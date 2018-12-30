package com.helloweenvsfei.core.aware;

import org.springframework.beans.factory.BeanNameAware;

public class WhatsTheNameBean implements BeanNameAware {

  private String beanName;                    // �P�� Bean ���W�r
  
  public void setBeanName(String beanName) {  // �x�s�W�r
	this.beanName=beanName;                   // Spring �|�I�s�Ӥ�k   
  }

  public void showBean(){
	System.out.println("Bean name : "+this.beanName);  
  }
  
}
