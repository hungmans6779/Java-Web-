package com.spring.core.destroy;

import org.springframework.beans.factory.DisposableBean;

/*
 *  DisposableBean ��������P����k
 *  
 *  ��{�F DisposableBean ������ JavaBean �|�b�����󪺮ɭԩI�s�P����k�C
 *  ���ϥθӤ����|�P Spring �{���X�o�ͽ��X�A�]�������˨ϥΡC
 */
public class DestroyBean01 implements DisposableBean {
	
  private String message;

  public String getMessage() {
	return message;
  }

  public void setMessage(String message) {
	this.message = message;
  }

  
  public void showInfo(){
	System.out.println(DestroyBean01.class.getName()+",showInfo() execute...");
	System.out.println("message = "+message);
  }
  
  
  
  
  public void destroy() throws Exception {
	System.out.println(DestroyBean01.class.getName()+",destroy() execute...");
  }

  
			 
}
