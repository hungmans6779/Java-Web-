package com.spring.aop.service.impl;

import javax.security.auth.login.AccountException;

import com.spring.aop.service.IAopService;

/*
 *  ��@ IAopService ������
 */
public class AopServiceImpl implements IAopService {

  private String name;

  public String getName() {
	return name;
  }

  public void setName(String name) {
    System.out.println(AopServiceImpl.class.getName()+",setName() Method execute....");
    System.out.println("name = "+name);
	this.name = name;
  }

	
	
  // �|�Q�d�I
  public void withAop() throws Exception {
	System.out.println("\n");
	System.out.println(AopServiceImpl.class.getName()+",withAop()  execute...");
    System.out.println("�� AOP ����ư���Cname = "+name);
    System.out.println("\n");
    if(name.trim().length() ==0 ){
      throw new AccountException("name �ݩʤ��ର��");
    }
  } // end withAop()
 
	
  
  // ���|�Q�d�I
  public void withoutAop() throws Exception {
	System.out.println("\n");
	System.out.println(AopServiceImpl.class.getName()+",withoutAop()  execute...");
 	System.out.println("�S�� AOP ����ư���Cname = "+name);
 	System.out.println("\n"); 
  } // end withoutAop()
  
  

}
